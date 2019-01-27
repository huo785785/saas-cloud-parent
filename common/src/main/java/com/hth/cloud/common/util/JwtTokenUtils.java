package com.hth.cloud.common.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import java.io.Serializable;
import java.util.*;

/**
* @ClassName:       JwtTokenUtils
*                   JWT工具类
* @Author:          霍天豪
* @CreateDate:      2019/1/27 18:38
* @UpdateUser:      霍天豪
* @UpdateDate:      2019/1/27 18:38
* @Version:         0.0.1
*/
@Slf4j
public class JwtTokenUtils implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/**
	 * 创建时间
	 */
	private static final String CREATED = "created";
	/**
	 * 权限列表
	 */
	private static final String AUTHORITIES = "authorities";
	/**
     * 密钥
     */
    private static final String SECRET = "hth-cloud";
    /**
     * 有效期12小时
     */
    private static final long EXPIRE_TIME = 12 * 60 * 60 * 1000;

	/**
	 * 从数据声明生成令牌
	 * @Author:      霍天豪
	 * @CreateDate:  2019/1/27 20:05
	 * @UpdateUser:
	 * @UpdateDate:  2019/1/27 20:05
	 * @Version:     0.0.1
	 * @param claims
	 * @param expire
	 * @param secret
	 * @return       java.lang.String
	 * @throws
	 */
    public static String generateToken(Map<String, Object> claims) {
		claims.put(CREATED, new Date());
        Date expirationDate = new Date(System.currentTimeMillis() + EXPIRE_TIME);
        return Jwts.builder().setHeaderParam("typ", "JWT").setClaims(claims).setExpiration(expirationDate).signWith(SignatureAlgorithm.HS512, SECRET).compact();
    }

	/**
	 * 从token获取权限
	 * @Author:      霍天豪
	 * @CreateDate:  2019/1/27 18:40
	 * @UpdateUser:
	 * @UpdateDate:  2019/1/27 18:40
	 * @Version:     0.0.1
	 * @param token
	 * @return       java.util.List<java.lang.String>
	 * @throws
	 */
	public static List<String>getPermission(String token){
		List<String> permission=null;
		try {
			Claims claims = getClaimsFromToken(token);
			permission = (List<String>) claims.get(AUTHORITIES);
		} catch (Exception e) {
			log.error("eror={}",e);
		}
		return permission;
	}
	/**
	 * 从令牌中获取数据声明
	 * @Author:      霍天豪
	 * @CreateDate:  2019/1/27 18:41
	 * @UpdateUser:
	 * @UpdateDate:  2019/1/27 18:41
	 * @Version:     0.0.1
	 * @param token
	 * @return       io.jsonwebtoken.Claims
	 * @throws
	 */
    public static Claims getClaimsFromToken(String token) {
        Claims claims;
        try {
            claims = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token).getBody();
        } catch (Exception e) {
            claims = null;
        }
        return claims;
    }

	/**
	 * 验证令牌
	 * @Author:      霍天豪
	 * @CreateDate:  2019/1/27 18:41
	 * @UpdateUser:
	 * @UpdateDate:  2019/1/27 18:41
	 * @Version:     0.0.1
	 * @param token
	 * @param username
	 * @return       java.lang.Boolean
	 * @throws
	 */
	public static Boolean validateToken(String token) {
		Claims claimsFromToken = getClaimsFromToken(token);
		return (null!=claimsFromToken && !isTokenExpired(token));
	}

	/**
	 * 刷新令牌
	 * @Author:      霍天豪
	 * @CreateDate:  2019/1/27 20:05
	 * @UpdateUser:
	 * @UpdateDate:  2019/1/27 20:05
	 * @Version:     0.0.1
	 * @param token
	 * @param expire
	 * @param secret
	 * @return       java.lang.String
	 * @throws
	 */
	public static String refreshToken(String token) {
	    String refreshedToken;
	    try {
	        Claims claims = getClaimsFromToken(token);
	        claims.put(CREATED, new Date());
	        refreshedToken = generateToken(claims);
	    } catch (Exception e) {
	        refreshedToken = null;
			log.error("error={}",e);
	    }
	    return refreshedToken;
	}

	/**
	 * 判断令牌是否过期
	 * @Author:      霍天豪
	 * @CreateDate:  2019/1/27 20:07
	 * @UpdateUser:
	 * @UpdateDate:  2019/1/27 20:07
	 * @Version:     0.0.1
	 * @param token
	 * @return       java.lang.Boolean
	 * @throws
	 */
    public static Boolean isTokenExpired(String token) {
        try {
            Claims claims = getClaimsFromToken(token);
            Date expiration = claims.getExpiration();
            return expiration.before(new Date());
        } catch (Exception e) {
        	log.error("error={}",e);
            return false;
        }
    }

}