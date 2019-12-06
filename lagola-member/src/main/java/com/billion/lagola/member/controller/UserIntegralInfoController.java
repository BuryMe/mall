package com.billion.lagola.member.controller;


import com.billion.lagola.member.req.BasePageReq;
import com.billion.lagola.member.service.IUserIntegralInfoService;
import com.billion.lagolacommon.commons.ApiReturn;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.Optional;

/**
 * <p>
 * 用户积分表 前端控制器
 * </p>
 *
 * @author jobob
 * @since 2019-12-04
 */
@RestController
@RequestMapping("/user-integral-info")
@Api(tags = "用户积分前端控制器")
public class UserIntegralInfoController {

    @Resource
    IUserIntegralInfoService userIntegralInfoService;

    @PostMapping("/get")
    @ApiOperation(value = "分页获取用户积分详情", notes = "根据userId去查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户编号", required = true, dataType = "Long"),
            @ApiImplicitParam(name = "pageNo", value = "分页页码", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "分页大小", required = true, dataType = "Integer")
    })
    public ApiReturn get(@Valid @RequestBody BasePageReq basePageReq) {
        Optional.ofNullable(basePageReq.getUserId()).orElseThrow(() -> new IllegalArgumentException("userId 不能为空"));
        return ApiReturn.build().ok(userIntegralInfoService.getPageByUserId(basePageReq));
    }

}
