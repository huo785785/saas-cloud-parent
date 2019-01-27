package com.hth.cloud.dto.user;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName: RegisterReqDTO
 * 注册
 * @Author: huoth
 * @CreateDate: 2019/1/17 18:02
 * @UpdateUser: huoth
 * @UpdateDate: 2019/1/17 18:02
 * @Version: 0.0.1
 */
@Data
public class RegisterReqDTO implements Serializable{
    private static final long serialVersionUID = 7744186963856423029L;
    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 所属机构id
     */
    private String deptId;

    /**
     * 真实名称
     */
    private String realName;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 手机号码
     */
    private String phone;

    /**
     * 电子邮箱
     */
    private String email;

    /**
     * 性别
     */
    private Integer sex;

    /**
     * 创建人id
     */
    private String createId;

    /**
     * 更新人id
     */
    private String updateId;

    /**
     * 来源
     */
    private Integer createWhere;

}
