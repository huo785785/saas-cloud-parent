package com.hth.cloud.filter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hth.cloud.common.base.HgResult;
import com.hth.cloud.common.exception.BusinessException;
import com.hth.cloud.common.exception.code.BaseResponseCode;
import com.hth.cloud.common.util.JwtTokenUtils;
import com.hth.cloud.config.FilterConfig;
import com.hth.cloud.constant.UserTokenConstant;
import com.hth.cloud.fegin.user.IMenuFeignService;
import com.hth.entity.user.SysMenu;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.connector.Response;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @ClassName: AccessFilter
 *
 * @Author: huoth
 * @CreateDate: 2019/1/14 10:51
 * @UpdateUser: huoth
 * @UpdateDate: 2019/1/14 10:51
 * @Version: 0.0.1
 */
@Slf4j
@Service
public class AccessFilter extends ZuulFilter{
    @Autowired
    private IMenuFeignService menuFeignService;
    @Autowired
    private FilterConfig filterConfig;
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        String ignoresParam = filterConfig.getIgnores();
        String[] ignoreArray = ignoresParam.split(",");
        RequestContext ctx = RequestContext.getCurrentContext();
        ctx.getResponse().setContentType("text/html;charset=UTF-8");
        HttpServletRequest request = ctx.getRequest();
        String requestUrl = request.getRequestURL().toString();
        String method = request.getMethod().toString();
        log.info("requestUrl={} method={}",requestUrl,method);
        try {
            for (int i = 0; i < ignoreArray.length; i++) {
                if (request.getRequestURL().toString().contains(ignoreArray[i])) {
                    // 对该请求进行路由
                    ctx.setSendZuulResponse(true);
                    ctx.setResponseStatusCode(200);
                    log.info("{}请求不需要鉴权。", requestUrl);
                    return null;

                }
            }

            String token = getToken(request);
            if(StringUtils.isBlank(token)){
                throw new BusinessException(BaseResponseCode.TOKEN_EMPT);
            }
            if(!JwtTokenUtils.validateToken(token)){
                throw new BusinessException(BaseResponseCode.TOKEN_PAST_DUE);
            }

            /**
             * 判断有没有权限
             */
           if(isPermission(JwtTokenUtils.getUserId(token),requestUrl,method)) {
               Claims claims = JwtTokenUtils.getClaimsFromToken(token);
               // 添加ACCOUNTID进入头信息
               ctx.addZuulRequestHeader(UserTokenConstant.LOGIN_JWT_CLAIMS_USERNAME,
                       String.valueOf(claims.get(UserTokenConstant.LOGIN_JWT_CLAIMS_USERNAME)));
               ctx.addZuulRequestHeader(UserTokenConstant.LOGIN_JWT_CLAIMS_USER_ID,
                       claims.getSubject());
               return null;
           }
            throw new BusinessException(BaseResponseCode.NOT_ACCESS_RESOURCES_PERMISSION);


        }catch (BusinessException e){
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(Response.SC_OK);
            ctx.addZuulResponseHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_UTF8_VALUE);
            HgResult<Object> hgResult = HgResult.getHgResult(e.getMessageCode(), e.getDetailMessage());
            ctx.setResponseBody(JSON.toJSONString(hgResult));
            return null;
        }
        catch (Exception e) {
            log.info("token error :", e);
            ctx.addZuulResponseHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_UTF8_VALUE);
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(200);
            ctx.setResponseBody(JSON.toJSONString(HgResult.getHgResult(BaseResponseCode.SERVICECALLEXCEPTION)));
            return null;
        }

    }

    /**
     * 获取请求token
     * @param request
     * @return
     */
    private  String getToken(HttpServletRequest request) {
        String token = request.getHeader(HttpHeaders.AUTHORIZATION);
        String tokenHead = "HTHBearer ";
        if(token == null) {
            token = request.getHeader("token");
        } else if(token.contains(tokenHead)){
            token = token.substring(tokenHead.length());
        }
        if("".equals(token)) {
            token = null;
        }
        return token;
    }
    /**
     * 判断是否有权限
     * @Author:      霍天豪
     * @CreateDate:  2019/1/28 22:49
     * @UpdateUser:
     * @UpdateDate:  2019/1/28 22:49
     * @Version:     0.0.1
     * @param userId
     * @param requestUrl
     * @param method
     * @return       boolean
     * @throws
     */
 private boolean isPermission(String userId,String requestUrl,String method){
     HgResult<List<SysMenu>> menuByUserId = menuFeignService.getMenuByUserId(userId);
     List<SysMenu>permissions=HgResult.getData(menuByUserId);
     try {
         PathMatcher matcher = new AntPathMatcher();
         for(SysMenu sysMenu:permissions){
             if(method.equals(sysMenu.getMethod())&&matcher.match(sysMenu.getUrl(),requestUrl)){
                 return true;
             }
         }
     } catch (Exception e) {
         return false;
     }
     return false;
 }
}
