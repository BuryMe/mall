package com.billion.lagolacommon.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Auther: fusw
 * @Date: 2019-12-05 09:46
 * @Description: 自定义服务异常
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ServiceException extends RuntimeException {

    private Integer code;
    private String msg;

    public ServiceException(Integer code, String msg) {
        super();
        this.code = code;
        this.msg = msg;
    }

    public ServiceException(String errorMsg) {
        this.code = 500;
        this.msg = errorMsg;
    }

    public ServiceException(Throwable e) {
        this.code = 500;
        this.msg = e.getMessage();
    }


}
