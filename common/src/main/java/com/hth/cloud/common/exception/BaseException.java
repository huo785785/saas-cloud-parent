package com.hth.cloud.common.exception;

import lombok.Data;

/**
* @ClassName:       BaseException
*                   基础异常
* @Author:          huoth
* @CreateDate:      2019/1/5 16:03
* @UpdateUser:      huoth
* @UpdateDate:      2019/1/5 16:03
* @Version:         0.0.1
*/
@Data
public class BaseException extends RuntimeException {

    private static final long serialVersionUID = 906670803351818092L;

    /**
     * 异常编号
     */
    private final int messageCode;

    /**
     * 对messageCode 异常信息进行补充说明
     */
    private final String detailMessage;

    public int getMessageCode() {
        return messageCode;
    }

    public String getDetailMessage() {
        return detailMessage;
    }

    public BaseException(int messageCode) {
        this.messageCode = messageCode;
        this.detailMessage = "";
    }

    public BaseException(int messageCode, String message) {
        super(message);
        this.messageCode = messageCode;
        this.detailMessage = message;
    }

    public BaseException(int messageCode, String message, String detailMessage) {
        super(message);
        this.messageCode = messageCode;
        this.detailMessage = detailMessage;
    }

}