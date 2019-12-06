package com.billion.lagola.member.controller;


import com.billion.lagola.member.req.UserBaseInfoReq;
import com.billion.lagola.member.service.IUserBaseInfoService;
import com.billion.lagolacommon.commons.ApiReturn;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
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
@Api(tags = "用户信息前端控制器")
public class UserBaseInfoController {

    @Resource
    IUserBaseInfoService userBaseInfoService;

    @PostMapping("/get")
    @ApiOperation(value = "查询用户基本信息", notes = "除了分页参数必传,其他都是非必传参数。")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户编号", dataType = "Long"),
            @ApiImplicitParam(name = "pageNo", value = "分页页码", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "分页页大小", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "name", value = "用户名字", dataType = "String"),
            @ApiImplicitParam(name = "mobileNo", value = "用户手机号", dataType = "String"),
            @ApiImplicitParam(name = "idCardNo", value = "用户身份证件号", dataType = "String")
    })
    public ApiReturn get(@Valid @NotNull(message = "请求参数不能为空") @RequestBody UserBaseInfoReq userBaseInfoReq) {
        return ApiReturn.build().ok(userBaseInfoService.getPageByParam(userBaseInfoReq));
    }


}
