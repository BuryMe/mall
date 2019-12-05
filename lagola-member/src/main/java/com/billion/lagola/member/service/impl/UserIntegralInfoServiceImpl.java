package com.billion.lagola.member.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.billion.lagola.member.entity.UserIntegralInfo;
import com.billion.lagola.member.mapper.UserIntegralInfoMapper;
import com.billion.lagola.member.req.BasePageReq;
import com.billion.lagola.member.service.IUserIntegralInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.nio.file.OpenOption;
import java.util.List;
import java.util.Optional;

/**
 * <p>
 * 用户积分表 服务实现类
 * </p>
 *
 * @author jobob
 * @since 2019-12-04
 */
@Slf4j
@Service
public class UserIntegralInfoServiceImpl extends ServiceImpl<UserIntegralInfoMapper, UserIntegralInfo> implements IUserIntegralInfoService {

    @Resource
    UserIntegralInfoMapper integralInfoMapper;

    @Override
    public IPage<UserIntegralInfo> getPageByUserId(BasePageReq basePageReq) {
        LambdaQueryWrapper<UserIntegralInfo> lambdaQueryWrapper = new QueryWrapper<UserIntegralInfo>().lambda();
        lambdaQueryWrapper.eq(UserIntegralInfo::getUserId, basePageReq.getUserId());
        IPage<UserIntegralInfo> page = new Page<>(basePageReq.getPageNo(), basePageReq.getPageSize());
        return integralInfoMapper.selectPage(page, lambdaQueryWrapper);
    }
}
