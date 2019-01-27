package com.hth.cloud.common.exception.code;

/**
 * @ClassName: ResponseCodeInterface
 * 错误码接口
 * @Author: huoth
 * @CreateDate: 2019/1/5 15:28
 * @UpdateUser: huoth
 * @UpdateDate: 2019/1/5 15:28
 * @Version: 0.0.1
 */
public interface ResponseCodeInterface {

    int getCode();

    String getMsg();

    String getEnMsg();
}
