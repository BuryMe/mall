package com.billion.lagola.member.config;

import com.billion.lagolacommon.commons.ApiReturn;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Auther: fusw
 * @Date: 2019-12-05 14:00
 * @Description: 全局异常处理
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ApiReturn handler(Exception e) {
        log.error(e.getMessage(), e);
        return ApiReturn.build().exception(e);
    }

}
