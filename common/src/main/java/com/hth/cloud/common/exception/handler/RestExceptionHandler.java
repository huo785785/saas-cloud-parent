package com.hth.cloud.common.exception.handler;

import com.hth.cloud.common.base.HgResult;
import com.hth.cloud.common.exception.BusinessException;
import com.hth.cloud.common.exception.code.BaseResponseCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.IOException;
import java.util.List;

/**
 * @ClassName: RestExceptionHandler
 * 统一异常处理 异常增强，以JSON的形式返回给客服端
 * @Author: huoth
 * @CreateDate: 2019/1/5 15:44
 * @UpdateUser: huoth
 * @UpdateDate: 2019/1/5 15:44
 * @Version: 0.0.1
 */
@RestControllerAdvice
@Slf4j
public class RestExceptionHandler {
    /**
     * 空指针异常
     * @Author:      huoth
     * @CreateDate:  2019/1/5 15:51
     * @UpdateUser:
     * @UpdateDate:  2019/1/5 15:51
     * @Version:     0.0.1
     * @param e
     * @return       com.hth.cloud.common.base.HgResult<T>
     * @throws
     */
    @ExceptionHandler(NullPointerException.class)
    public <T>HgResult<T> nullpointerException(NullPointerException e){
       log.error("nullPointerExceptionHandler,exception:{}", e);
       return HgResult.getHgResult(BaseResponseCode.NULLPOINTEREXCEPTION);
    }
    /**
     * 类型转换异常
     * @Author:      huoth
     * @CreateDate:  2019/1/5 15:52
     * @UpdateUser:
     * @UpdateDate:  2019/1/5 15:52
     * @Version:     0.0.1
     * @param e
     * @return       com.hth.cloud.common.base.HgResult<T>
     * @throws
     */
    @ExceptionHandler(ClassCastException.class)
    public <T> HgResult<T> classCastExceptionHandler(ClassCastException e) {
        log.error("classCastExceptionHandler,exception:{}", e);
        return HgResult.getHgResult(BaseResponseCode.CLASSCASTEXCEPTION);
    }

    /**
     * IO异常
     * @Author:      huoth
     * @CreateDate:  2019/1/5 15:53
     * @UpdateUser:
     * @UpdateDate:  2019/1/5 15:53
     * @Version:     0.0.1
     * @param e
     * @return       com.hth.cloud.common.base.HgResult<T>
     * @throws
     */
    @ExceptionHandler(IOException.class)
    public <T> HgResult<T> iOExceptionHandler(IOException e) {
        log.error("iOExceptionHandler,exception:{}", e);
        return HgResult.getHgResult(BaseResponseCode.IOEXCEPTION);
    }
    /**
     * 未知方法异常
     * @Author:      huoth
     * @CreateDate:  2019/1/5 15:54
     * @UpdateUser:
     * @UpdateDate:  2019/1/5 15:54
     * @Version:     0.0.1
     * @param e
     * @return       com.hth.cloud.common.base.HgResult<T>
     * @throws
     */
    @ExceptionHandler(NoSuchMethodException.class)
    public <T> HgResult<T> noSuchMethodExceptionHandler(NoSuchMethodException e) {
        log.error("noSuchMethodExceptionHandler,exception:{}", e);
        return HgResult.getHgResult(BaseResponseCode.NOSUCHMETHODEXCEPTION);
    }

    /**
     * 数组越界异常
     * @Author:      huoth
     * @CreateDate:  2019/1/5 15:55
     * @UpdateUser:
     * @UpdateDate:  2019/1/5 15:55
     * @Version:     0.0.1
     * @param e
     * @return       com.hth.cloud.common.base.HgResult<T>
     * @throws
     */
    @ExceptionHandler(IndexOutOfBoundsException.class)
    public <T> HgResult<T> indexOutOfBoundsExceptionHandler(IndexOutOfBoundsException e) {
        log.error("indexOutOfBoundsExceptionHandler,exception:{}", e);
        return HgResult.getHgResult(BaseResponseCode.INDEXOUTOFBOUNDSEXCEPTION);
    }
    /**
     * 其他异常
     * @Author:      huoth
     * @CreateDate:  2019/1/5 15:56
     * @UpdateUser:
     * @UpdateDate:  2019/1/5 15:56
     * @Version:     0.0.1
     * @param e
     * @return       com.hth.cloud.common.base.HgResult<T>
     * @throws
     */
    @ExceptionHandler(Exception.class)
    public <T> HgResult<T> runtimeExceptionHandler(RuntimeException e) {
        log.error("runtimeExceptionHandler exception:{}", e);
        return HgResult.getHgResult(BaseResponseCode.OTHEREXCEPTION);
    }
    /**
     * 自定义全局异常处理
     * @Author:      huoth
     * @CreateDate:  2019/1/22 18:01
     * @UpdateUser:
     * @UpdateDate:  2019/1/22 18:01
     * @Version:     0.0.1
     * @param e
     * @return       com.hth.cloud.common.base.HgResult<T>
     * @throws
     */
    @ExceptionHandler(value = BusinessException.class)
    <T> HgResult<T> businessExceptionHandler(BusinessException e) {
        return HgResult.getHgResult(e.getMessageCode(), e.getMessage());
    }

    /**
     * 处理validation 框架异常
     * @Author:      huoth
     * @CreateDate:  2019/1/5 16:01
     * @UpdateUser:
     * @UpdateDate:  2019/1/5 16:01
     * @Version:     0.0.1
     * @param e
     * @return       com.hth.cloud.common.base.HgResult<T>
     * @throws
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    <T> HgResult<T> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        log.error("methodArgumentNotValidExceptionHandler bindingResult.allErrors():{},exception:{}", e.getBindingResult().getAllErrors(), e);
        List<ObjectError> errors = e.getBindingResult().getAllErrors();
        return createValidExceptionResp(errors);
    }
    private <T> HgResult<T> createValidExceptionResp(List<ObjectError> errors) {
        String[] msgs = new String[errors.size()];
        int i = 0;
        for (ObjectError error : errors) {
            msgs[i] = error.getDefaultMessage();
            i++;
        }
        return HgResult.getHgResult(BaseResponseCode.METHODARGUMENTNOTVALIDEXCEPTION.getCode(), msgs[0]);
    }


}
