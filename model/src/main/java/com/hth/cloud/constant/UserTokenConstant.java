package com.hth.cloud.constant;

/**
* @ClassName:       UserTokenConstant
*                   用户登录相关常量
* @Author:          huoth
* @CreateDate:      2019/1/16 17:55
* @UpdateUser:      huoth
* @UpdateDate:      2019/1/16 17:55
* @Version:         0.0.1
*/
public class UserTokenConstant {

    /**
     * 用户token缓存前缀
     */
    public final static String ACCOUNT_FAILURE_TOKEN_CACHE_PREFIX = "hg_account_token";

    /**
     * 缓存key分隔符
     */
    public static final String CACHE_KEY_SEPARATOR_STR = "_";

    /**
     * jwt claims id 信息
     */
    public final static String LOGIN_JWT_CLAIMS_ACCOUNT_ID = "accountId";

    /**
     * jwt claims userId 信息
     */
    public final static String LOGIN_JWT_CLAIMS_USER_ID = "userId";

    /**
     * jwt claims 用戶身份信息
     */
    public final static String LOGIN_JWT_CLAIMS_ACCOUNTTYPE = "userType";

    /**
     * jwt claims 用户登录IP
     */
    public final static String LOGIN_JWT_CLAIMS_IP = "ip";

    /**
     * jwt claims account 信息
     */
    public final static String LOGIN_JWT_CLAIMS_USERNAME = "username";

    /**
     * jwt claims 用户登录状态
     */
    public final static String LOGIN_JWT_CLAIMS_STATUS = "status";

    /**
     *  账号状态-正常：1
     */
    public final static String  ACCOUNT_STATUS_NORMAL = "1";
    /**
     *  账号状态-异常：-1
     */
    public final static String  ACCOUNT_STATUS_ABNORMAL  = "-1";

    /**
     *  登录密码错误次数redis key前缀 + accountId
     */
    public final static String PWORD_INPUT_ERROR_PRE = "password_input_error_";



}
