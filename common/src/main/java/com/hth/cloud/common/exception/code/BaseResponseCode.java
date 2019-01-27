package com.hth.cloud.common.exception.code;

/**
 * @ClassName: BaseResponseCode
 * 通用错误码  0 1000 - 1999 通用异常码  其他业务系统错误码以1000的区间大小划分
 *  业务系统错误码不在此类中体现,各业务系统自己创建各自的错误常量类
 * @Author: huoth
 * @CreateDate: 2019/1/5 15:28
 * @UpdateUser: huoth
 * @UpdateDate: 2019/1/5 15:28
 * @Version: 0.0.1
 */
public enum  BaseResponseCode implements ResponseCodeInterface{

    /**
     * 请求成功
     */
    SUCCESS(0, "请求成功","Success"),
    /**
     * 未知异常
     */
    OTHEREXCEPTION(1000, "未知异常","OtherException"),
    /**
     * 空指针异常
     */
    NULLPOINTEREXCEPTION(1001, "空指针异常","NullPointerException"),
    /**
     * 类型转换异常
     */
    CLASSCASTEXCEPTION(1002, "类型转换异常","ClassCastException"),
    /**
     * IO异常
     */
    IOEXCEPTION(1003, "IO异常","IOException"),
    /**
     * 未知方法异常
     */
    NOSUCHMETHODEXCEPTION(1004, "未知方法异常","NoSuchMethodException"),
    /**
     * 数组越界异常
     */
    INDEXOUTOFBOUNDSEXCEPTION(1005, "数组越界异常","IndexOutOfBoundsException"),
    /**
     * Http消息不可读异常
     */
    HTTPMESSAGENOTREADABLEEXCEPTION(1006, "Http消息不可读异常","HttpMessageNotReadableException"),
    /**
     * Http消息不可写异常
     */
    HTTPMESSAGENOTWRITABLEEXCEPTION(1007, "Http消息不可写异常","HttpMessageNotWritableException"),
    /**
     * 类型不匹配异常
     */
    TYPEMISMATCHEXCEPTION(1008, "类型不匹配异常","TypeMismatchException"),
    /**
     * 方法参数校验异常
     */
    METHODARGUMENTNOTVALIDEXCEPTION(1009, "方法参数校验异常","MethodArgumentNotValidException"),
    /**
     * 处理转换不支持异常
     */
    HANDLECONVERSIONNOTSUPPORTEDEXCEPTION(1010, "处理转换不支持异常","conversionNotSupportedExceptionHandle"),
    /**
     * 服务调用异常
     */
    SERVICECALLEXCEPTION(1011, "服务调用异常","Service call exception"),


    /**
     * 令牌信息无效
     */
    TOKEN_EMPT(1012, "授权信息为空","Authorization information is empty"),
    /**
     * 令牌信息无效
     */
    TOKEN_ERROR(1013, "授权信息信息无效","Token information is invalid"),

    /**
     * 令牌已过期
     */
    TOKEN_PAST_DUE(1014, "授权信息已过期，请您重新登录","Since you have not operated for a long time, please log in again!"),

    /**
     * 解析应用授权信息失败
     */
    TOKEN_PARSE_ERROR(1015, "解析应用授权信息失败","Parsing application authorization information failure"),

    /**
     * 解析应用授权信息失败
     */
    TOKEN_HAS_RESET(1016, "授权信息已被重置","The authorization has been reset"),

    /**
     * 签名校验失败
     */
    SIGNATURE_ERROR(1017, "签名校验失败","Signature verification failure"),

    /**
     * 系统繁忙，请稍候再试
     */
    SYSTEM_BUSY(1018, "系统繁忙，请稍候再试"),

    /**
     * 手机号码有误
     */
    PHONE_ERROR(1019, "手机号码有误，请重新输入","phone error"),

    /**
     * 邮箱地址格式有误
     */
    EMAIL_ERROR(1020, "邮箱地址格式有误，请重新输入","email error"),

    /**
     * 短信发送失败
     */
    SMS_SEND_ERROR(1021, "短信发送失败","sms send error"),

    /**
     * 邮件发送失败
     */
    MAIL_SEND_ERROR(1022, "邮件发送失败","mail send error"),

    /**
     * 账号异常
     */
    ABNORMAL_ACCOUNT(2001, "账号异常","Abnormal account, abnormal forced offline"),

    /**
     * 请求的内容不存在
     */
    DATA_IS_NULL(2002, "请求的内容不存在"),
    /**
     * 没有访问权限
     */
    NOT_ACCESS_RESOURCES_PERMISSION(2003, "没有访问该资源的权限"),


   //user-api 3000~5000
    /**
     * 没有访问权限
     */
    NOT_ACCOUNT(3000, "该用户不存在,请注册后再登录"),
    PASSWORD_ERROR(3001, "用户名或密码不正确！"),
    ;
    /**
     * 错误码
     */
    private final int code;
    /**
     * 错误消息
     */
    private final String msg;

    /**
     * 错误消息（英文）
     */
    private final String enMsg;

    BaseResponseCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
        this.enMsg = "";
    }

    BaseResponseCode(int code, String msg, String enMsg) {
        this.code = code;
        this.msg = msg;
        this.enMsg = enMsg;
    }
    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return msg;
    }

    @Override
    public String getEnMsg() {
        return enMsg;
    }
}
