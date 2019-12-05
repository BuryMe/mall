package com.billion.lagola.member.controller;


import com.billion.lagola.member.service.IUserRealInfoService;
import com.billion.lagolacommon.commons.ApiReturn;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;

/**
 * <p>
 * 用户实名信息表
 前端控制器
 * </p>
 *
 * @author jobob
 * @since 2019-12-04
 */
@RestController
@RequestMapping("/user-real-info")
public class UserRealInfoController {

    @Resource
    IUserRealInfoService userRealInfoService;

    @ApiOperation(value = "获取用户实名数据", notes = "根据userId去查询")
    @ApiImplicitParam(name = "userId", value = "用户编号", required = true, dataType = "Long")
    @GetMapping("/get")
    public ApiReturn get(@NotNull(message = "用户号不能为空") Long userId) {
        return ApiReturn.build().ok(userRealInfoService.getByUserId(userId));
    }


}
