package com.billion.lagola.member.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.billion.lagola.member.entity.UserQuotaInfo;
import com.billion.lagola.member.mapper.UserQuotaInfoMapper;
import com.billion.lagola.member.service.IUserQuotaInfoService;
import com.billion.lagolacommon.commons.ApiReturn;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * <p>
 * 用户额度信息表 前端控制器
 * </p>
 *
 * @author jobob
 * @since 2019-12-04
 */
@RestController
@RequestMapping("/user-quota-info")
@Api(tags = "用户授信额度前端控制器")
@Validated
public class UserQuotaInfoController {

    @Resource
    IUserQuotaInfoService userQuotaInfoService;

    @ApiOperation(value = "获取用户额度详情", notes = "根据userId去查询")
    @ApiImplicitParam(name = "userId", value = "用户编号", required = true, dataType = "Long")
    @GetMapping("/get")
    public ApiReturn get(@NotNull(message = "用户号不能为空") Long userId) throws Exception {
        return ApiReturn.build().ok(userQuotaInfoService.getByUserId(userId));
    }




}
