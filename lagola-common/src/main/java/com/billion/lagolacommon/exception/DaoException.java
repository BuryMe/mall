package com.billion.lagolacommon.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Auther: fusw
 * @Date: 2019-12-05 10:08
 * @Description: 自定义数据库异常
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class DaoException extends RuntimeException {

    private Integer code;
    private String msg;

    public DaoException(Integer code, String msg) {
        super();
        this.code = code;
        this.msg = msg;
    }

    public DaoException(String errorMsg) {
        this.code = 505;
        this.msg = errorMsg;
    }

    public DaoException(Throwable e) {
        this.code = 505;
        this.msg = e.getMessage();
    }

}
