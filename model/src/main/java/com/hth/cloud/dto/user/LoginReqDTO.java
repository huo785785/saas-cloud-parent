package com.hth.cloud.dto.user;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName: LoginReqDTO
 * 用户登录请求
 * @Author: huoth
 * @CreateDate: 2019/1/16 17:36
 * @UpdateUser: huoth
 * @UpdateDate: 2019/1/16 17:36
 * @Version: 0.0.1
 */
@Data
public class LoginReqDTO implements Serializable{
    private static final long serialVersionUID = -6314763113413854658L;
    private String username;
    private String password;
}
