package com.hth.cloud.common.base;

import com.hth.cloud.common.exception.BusinessException;
import com.hth.cloud.common.exception.code.BaseResponseCode;
import com.hth.cloud.common.exception.code.ResponseCodeInterface;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
* @ClassName:       HgResult
*                   rest请求返回结果类
* @Author:          huoth
* @CreateDate:      2019/1/5 15:21
* @UpdateUser:      huoth
* @UpdateDate:      2019/1/5 15:21
* @Version:         0.0.1
*/
@Slf4j
@Data
public class HgResult <T> {
    public static final int DEFAULT_SUCCEED_CODE = 0;
    /**
     * 请求响应code，0为成功 其他为失败
     */
    private int code = DEFAULT_SUCCEED_CODE;

    /**
     * 响应异常码详细信息
     */
    private String msg;

    /**
     * 响应内容 ， code 0 时为 返回 数据
     */
    private T data;


    public HgResult() {
        this.code = BaseResponseCode.SUCCESS.getCode();
        this.msg = BaseResponseCode.SUCCESS.getMsg();
        this.data = null;
    }

    public HgResult(T data) {
        this.data = data;
        this.code = BaseResponseCode.SUCCESS.getCode();
        this.msg = BaseResponseCode.SUCCESS.getMsg();
    }

    public HgResult(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public HgResult(int code, String msg) {
        this.code = code;
        this.msg = msg;
        this.data = null;
    }

    public HgResult(ResponseCodeInterface responseCodeInterface) {
        this.data = null;
        this.code = responseCodeInterface.getCode();
        this.msg = responseCodeInterface.getMsg();
    }

    public HgResult(ResponseCodeInterface responseCodeInterface, T data) {
        this.data = data;
        this.code = responseCodeInterface.getCode();
        this.msg = responseCodeInterface.getMsg();
    }

    /**
     * 返回成功 data不为空
     *
     * @param data
     * @return com.hth.cloud.common.base.HgResult<T>
     * @throws
     * @Author: huoth
     * @CreateDate: 2019/1/5 15:37
     * @UpdateUser:
     * @UpdateDate: 2019/1/5 15:37
     * @Version: 0.0.1
     */
    public static <T> HgResult<T> success(T data) {
        return new <T>HgResult<T>(data);
    }

    /**
     * 返回成功 data为空
     *
     * @return com.hth.cloud.common.base.HgResult<T>
     * @throws
     * @Author: huoth
     * @CreateDate: 2019/1/5 15:37
     * @UpdateUser:
     * @UpdateDate: 2019/1/5 15:37
     * @Version: 0.0.1
     */
    public static <T> HgResult<T> success() {
        return new <T>HgResult<T>();
    }

    /**
     * 自定义返回值
     *
     * @param code 错误码
     * @param msg  错误信息
     * @param data 返回内容
     * @return com.hth.cloud.common.base.HgResult<T>
     * @throws
     * @Author: huoth
     * @CreateDate: 2019/1/5 15:41
     * @UpdateUser:
     * @UpdateDate: 2019/1/5 15:41
     * @Version: 0.0.1
     */
    public static <T> HgResult<T> getHgResult(int code, String msg, T data) {
        return new <T>HgResult<T>(code, msg, data);
    }
    /**
     * data 为null
     * @Author:      huoth
     * @CreateDate:  2019/1/5 16:00
     * @UpdateUser:
     * @UpdateDate:  2019/1/5 16:00
     * @Version:     0.0.1
     * @param code
     * @param msg
     * @return       com.hth.cloud.common.base.HgResult<T>
     * @throws
     */
    public static <T> HgResult<T> getHgResult(int code, String msg) {
        return new <T>HgResult<T>(code, msg);
    }
    /**
     * 传入枚举 data为null
     * @Author:      huoth
     * @CreateDate:  2019/1/5 15:50
     * @UpdateUser:
     * @UpdateDate:  2019/1/5 15:50
     * @Version:     0.0.1
     * @param responseCodeInterface
     * @return       com.hth.cloud.common.base.HgResult<T>
     * @throws
     */
    public static <T>HgResult<T>getHgResult(ResponseCodeInterface responseCodeInterface){
        return new <T>HgResult<T>(responseCodeInterface);
    }

    /**
     * 传入枚举 data不为null
     * @Author:      huoth
     * @CreateDate:  2019/1/5 15:50
     * @UpdateUser:
     * @UpdateDate:  2019/1/5 15:50
     * @Version:     0.0.1
     * @param responseCodeInterface
     * @return       com.hth.cloud.common.base.HgResult<T>
     * @throws
     */
    public static <T>HgResult<T>getHgResult(ResponseCodeInterface responseCodeInterface,T data){
        return new <T>HgResult<T>(responseCodeInterface,data);
    }
    /**
     * 获取底层服务返回成功的data
     * @Author:      huoth
     * @CreateDate:  2019/1/5 16:04
     * @UpdateUser:
     * @UpdateDate:  2019/1/5 16:04
     * @Version:     0.0.1
     * @param hgResult
     * @return       T
     * @throws
     */
    public static <T> T getData(HgResult<T> hgResult) {
        if (null == hgResult) {
            throw new BusinessException(BaseResponseCode.DATA_IS_NULL);
        }
        if (hgResult.getCode() != 0) {
            throw new BusinessException(hgResult.getCode(), hgResult.getMsg());
        }
        T data = hgResult.getData();
        return data;

    }
}