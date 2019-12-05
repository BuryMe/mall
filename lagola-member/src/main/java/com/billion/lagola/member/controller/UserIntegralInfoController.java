package com.billion.lagola.member.controller;


import com.billion.lagola.member.req.BasePageReq;
import com.billion.lagola.member.service.IUserIntegralInfoService;
import com.billion.lagolacommon.commons.ApiReturn;
import io.swagger.annotations.ApiImplicitParam;
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
public class UserIntegralInfoController {

    @Resource
    IUserIntegralInfoService userIntegralInfoService;

    @PostMapping("/get")
    @ApiOperation(value = "分页获取用户积分详情", notes = "根据userId去查询")
    @ApiImplicitParam(name = "userId", value = "用户编号", required = true, dataType = "Long")
    public ApiReturn get(@Valid @RequestBody BasePageReq basePageReq) {
        Optional.ofNullable(basePageReq.getUserId()).orElseThrow(() -> new IllegalArgumentException("userId 不能为空"));
        return ApiReturn.build().ok(userIntegralInfoService.getPageByUserId(basePageReq));
    }

}
