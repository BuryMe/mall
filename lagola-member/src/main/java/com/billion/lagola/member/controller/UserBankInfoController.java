package com.billion.lagola.member.controller;


import com.billion.lagola.member.req.BasePageReq;
import com.billion.lagola.member.service.IUserBankInfoService;
import com.billion.lagola.member.service.IUserIntegralInfoService;
import com.billion.lagolacommon.commons.ApiReturn;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.Optional;

/**
 * <p>
 * 用户银行卡信息表 前端控制器
 * </p>
 *
 * @author jobob
 * @since 2019-12-04
 */
@RestController
@RequestMapping("user-bank-info")
@Api(tags = "用户银行卡信息前端控制器")
public class UserBankInfoController {

    @Resource
    IUserBankInfoService userBankInfoService;

    @PostMapping("/get")
    @ApiOperation(value = "分页获取用户银行卡信息", notes = "根据userId去查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户编号", required = true, dataType = "Long"),
            @ApiImplicitParam(name = "pageNo", value = "分页页码", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "分页页大小", required = true, dataType = "Integer")
    })
    public ApiReturn get(@Valid @RequestBody BasePageReq basePageReq) {
        return ApiReturn.build().ok(userBankInfoService.getPageByUserId(basePageReq));
    }

}
