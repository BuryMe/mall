package com.billion.lagola.member.controller;


import com.billion.lagola.member.req.UserBaseInfoReq;
import com.billion.lagola.member.service.IUserBaseInfoService;
import com.billion.lagolacommon.commons.ApiReturn;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * <p>
 * 用户信息表 前端控制器
 * </p>
 *
 * @author jobob
 * @since 2019-12-04
 */
@RestController
@RequestMapping("/user-base-info")
public class UserBaseInfoController {

    @Resource
    IUserBaseInfoService userBaseInfoService;

    @PostMapping("/get")
    public ApiReturn get(@Valid  @NotNull(message = "请求参数不能为空") @RequestBody UserBaseInfoReq userBaseInfoReq) {
        return ApiReturn.build().ok(userBaseInfoService.getPageByParam(userBaseInfoReq));
    }


}
