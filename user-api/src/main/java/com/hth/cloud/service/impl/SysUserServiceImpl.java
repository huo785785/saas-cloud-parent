package com.hth.cloud.service.impl;

import com.github.pagehelper.PageHelper;
import com.hth.cloud.common.exception.BusinessException;
import com.hth.cloud.common.exception.code.BaseResponseCode;
import com.hth.cloud.common.util.JwtTokenUtils;
import com.hth.cloud.common.util.PageVO;
import com.hth.cloud.common.util.SnowflakeIdWorker;
import com.hth.cloud.constant.UserTokenConstant;
import com.hth.cloud.dto.user.LoginReqDTO;
import com.hth.cloud.dto.user.RegisterReqDTO;
import com.hth.cloud.mapper.SysUserMapper;
import com.hth.cloud.service.SysMenuService;
import com.hth.cloud.service.SysUserService;
import com.hth.cloud.util.PageUtils;
import com.hth.cloud.util.PasswordUtils;
import com.hth.cloud.vo.user.LoginRespVO;
import com.hth.entity.user.SysMenu;
import com.hth.entity.user.SysUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @ClassName: SysUserServiceImpl
 * 用户实现类
 * @Author: huoth
 * @CreateDate: 2019/1/8 22:30
 * @UpdateUser: huoth
 * @UpdateDate: 2019/1/8 22:30
 * @Version: 0.0.1
 */
@Service
public class SysUserServiceImpl implements SysUserService{
    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private SysMenuService sysMenuService;
    /**
     * 通过用户查找用户信息
     * @Author:      huoth
     * @CreateDate:  2019/1/8 22:51
     * @UpdateUser:
     * @UpdateDate:  2019/1/8 22:51
     * @Version:     0.0.1
     * @param name
     * @return       com.hth.entity.user.SysUser
     * @throws
     */
    @Override
    public SysUser getUserInfoByName(String name) {

        return sysUserMapper.getUserInfoByName(name);
    }
    /**
     * 新增用户
     * @Author:      huoth
     * @CreateDate:  2019/1/18 9:43
     * @UpdateUser:
     * @UpdateDate:  2019/1/18 9:43
     * @Version:     0.0.1
     * @param dto
     * @return       java.lang.String
     * @throws
     */
    @Override
    public String addUser(RegisterReqDTO dto) {
        SysUser sysUser=new SysUser();
        sysUser.setSalt(PasswordUtils.getSalt());
        String encode = PasswordUtils.encode(dto.getPassword(), sysUser.getSalt());
        dto.setPassword(encode);
        BeanUtils.copyProperties(dto,sysUser);
        sysUser.setCreateTime(new Date());
        sysUser.setId(SnowflakeIdWorker.getId()+"");
        sysUserMapper.insertSelective(sysUser);
        return sysUser.getId();
    }
    /**
     * 分页获取用户
     * @Author:      huoth
     * @CreateDate:  2019/1/18 16:05
     * @UpdateUser:
     * @UpdateDate:  2019/1/18 16:05
     * @Version:     0.0.1
     * @param pageNum
     * @param pageSize
     * @return       com.hth.cloud.common.util.PageVO<com.hth.entity.user.SysUser>
     * @throws
     */
    @Override
    public PageVO<SysUser> getUserList(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<SysUser> userList = sysUserMapper.getUserList();
        return PageUtils.getPageVO(userList);
    }
    /**
     * 用户登录
     * @Author:      霍天豪
     * @CreateDate:  2019/1/27 22:17
     * @UpdateUser:
     * @UpdateDate:  2019/1/27 22:17
     * @Version:     0.0.1
     * @param dto
     * @return       com.hth.cloud.vo.user.LoginRespVO
     * @throws
     */
    @Override
    public LoginRespVO login(LoginReqDTO dto) {
        SysUser sysUser = sysUserMapper.getUserInfoByName(dto.getUsername());
        if(null==sysUser){
            throw new BusinessException(BaseResponseCode.NOT_ACCOUNT);
        }
        if(!PasswordUtils.matches(sysUser.getSalt(),dto.getPassword(),sysUser.getPassword())){
            throw new BusinessException(BaseResponseCode.PASSWORD_ERROR);
        }
        Claims claims = Jwts.claims().setSubject(sysUser.getId());
        claims.put(UserTokenConstant.LOGIN_JWT_CLAIMS_USERNAME, sysUser.getUsername());
        String token=JwtTokenUtils.generateToken(claims);
        LoginRespVO vo=new LoginRespVO();
        BeanUtils.copyProperties(sysUser,vo);
        vo.setToken(token);
        vo.setUserId(sysUser.getId());
        return vo;
    }
}
