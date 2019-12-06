package com.billion.lagola.member.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.billion.lagola.member.entity.UserAddressInfo;
import com.billion.lagola.member.req.BasePageReq;
import com.billion.lagola.member.service.IUserAddressInfoService;
import com.billion.lagolacommon.commons.ApiReturn;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * <p>
 * 用户收货地址信息表 前端控制器
 * </p>
 *
 * @author jobob
 * @since 2019-12-04
 */
@RestController
@RequestMapping("user-address-info")
@Api(tags = "用户收货地址信息前端控制器")
public class UserAddressInfoController {

    @Resource
    IUserAddressInfoService userAddressInfoService;

    @PostMapping("/get")
    @ApiOperation(value = "分页获取用收获地址信息", notes = "根据userId去查询")
    @ApiImplicitParam(name = "userId", value = "用户编号", required = true, dataType = "Long")
    public ApiReturn get(@Valid @RequestBody BasePageReq basePageReq) {
        return ApiReturn.build().ok(userAddressInfoService.getPageByUserId(basePageReq));
    }

}
