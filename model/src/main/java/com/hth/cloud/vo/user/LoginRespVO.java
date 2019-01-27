package com.hth.cloud.vo.user;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName: LoginRespVO
 * 登录返回
 * @Author: huoth
 * @CreateDate: 2019/1/16 17:38
 * @UpdateUser: huoth
 * @UpdateDate: 2019/1/16 17:38
 * @Version: 0.0.1
 */
@Data
public class LoginRespVO implements Serializable{
    private static final long serialVersionUID = 5106941774542933311L;
    private String userId;

    private String token;

    private String username;

    private String password;

    private String deptId;

    private String realName;

    private String nickName;

    private String phone;

    private String email;

    private Integer status;

    private Integer sex;

    private Integer createWhere;

    private Date createTime;

}
