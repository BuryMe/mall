package com.billion.lagolacommon.commons;

import com.billion.lagolacommon.exception.DaoException;
import com.billion.lagolacommon.exception.ServiceException;
import lombok.Data;

import java.io.Serializable;

/**
 * {
 * "code":"000000",
 * "message":"消息",
 * "success":true,
 * "data":{
 * <p>
 * }
 *
 * @Auther: fusw
 * @Date: 2019-12-05 11:12
 * @Description:
 */
@Data
public class ApiReturn<T> implements Serializable {

    private static final long serialVersionUID = 6724043453743334646L;
    /**
     * 通信响应码
     */
    private Integer code;
    private String message;
    /**
     * 业务 是否成功
     */
    private Boolean success;
    private T data;


    public static ApiReturn build() {
        return new ApiReturn();
    }

    public ApiReturn ok() {
        this.code = 200;
        this.success = true;
        this.message = "ok";
        return this;
    }

    public ApiReturn ok(T data) {
        this.data = data;
        this.code = 200;
        this.message = "ok";
        this.success = true;
        return this;
    }

    public ApiReturn ok(T data, Boolean success) {
        this.data = data;
        this.success = success;
        this.code = 200;
        this.message = "ok";
        return this;
    }

    public ApiReturn ok(T data, Boolean success, String msg) {
        this.data = data;
        this.success = success;
        this.message = msg;
        this.code = 200;
        return this;
    }

    public ApiReturn ok(T data, Boolean success, String msg, Integer code) {
        this.data = data;
        this.success = success;
        this.message = msg;
        this.code = code;
        return this;
    }

    public ApiReturn fail(T data) {
        this.data = data;
        this.code = 500;
        this.message = "fail";
        this.success = false;
        return this;
    }

    public ApiReturn fail() {
        this.code = 500;
        this.message = "fail";
        this.success = false;
        return this;
    }

    public ApiReturn fail(T data, Boolean success) {
        this.data = data;
        this.success = false;
        this.code = 500;
        this.message = "fail";
        return this;
    }

    public ApiReturn fail(T data, Boolean success, String msg) {
        this.data = data;
        this.success = false;
        this.message = msg;
        this.code = 500;
        return this;
    }

    public ApiReturn fail(T data, Boolean success, String msg, Integer code) {
        this.data = data;
        this.success = success;
        this.message = msg;
        this.code = code;
        return this;
    }


    public ApiReturn exception(Throwable e) {
        this.code = 500;
        this.message = e.getMessage();
        this.success = false;
        return this;
    }

    public ApiReturn exception(ServiceException e) {
        this.code = e.getCode();
        this.message = e.getMessage();
        this.success = false;
        return this;
    }

    public ApiReturn exception(DaoException e) {
        this.code = e.getCode();
        this.message = e.getMessage();
        this.success = false;
        return this;
    }
}
