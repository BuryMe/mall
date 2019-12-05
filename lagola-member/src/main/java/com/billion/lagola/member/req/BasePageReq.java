package com.billion.lagola.member.req;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

/**
 * 基础 page request
 *
 * @Auther: fusw
 * @Date: 2019-12-05 14:55
 * @Description:
 */
@Data
@Validated
public class BasePageReq {

    protected Long userId;

    @NotNull(message = "分页页码不能为空")
    protected Integer pageNo;

    @NotNull(message = "分页页大小不能为空")
    protected Integer pageSize;

}
