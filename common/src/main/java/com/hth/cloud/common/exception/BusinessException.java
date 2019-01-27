package com.hth.cloud.common.exception;


import com.hth.cloud.common.exception.code.ResponseCodeInterface;

/**
* @ClassName:       BusinessException
*                   基础业务异常
* @Author:          huoth
* @CreateDate:      2019/1/5 16:03
* @UpdateUser:      huoth
* @UpdateDate:      2019/1/5 16:03
* @Version:         0.0.1
*/
public class BusinessException extends BaseException {

    private static final long serialVersionUID = 906670803351818092L;

    public BusinessException(int messageCode) {
        super(messageCode);
    }

    public BusinessException(int messageCode, String detailMessage) {
        super(messageCode, detailMessage);
    }

    /**
     * 构造函数
     * @param messageCode
     * @param detailMessage
     * @param throwable 保存引发异常的堆栈
     */
    public BusinessException(int messageCode, String detailMessage, Throwable throwable){
        super(messageCode,detailMessage);
        this.setStackTrace(throwable.getStackTrace());
    }

    /**
     * 构造函数
     * @param code 异常码
     */
    public BusinessException(ResponseCodeInterface code) {
        super(code.getCode(), code.getMsg());
    }

    @Override
    public String toString() {
        return super.toString();
    }
}