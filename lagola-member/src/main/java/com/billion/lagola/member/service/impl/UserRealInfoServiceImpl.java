package com.billion.lagola.member.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.billion.lagola.member.entity.UserQuotaInfo;
import com.billion.lagola.member.entity.UserRealInfo;
import com.billion.lagola.member.mapper.UserRealInfoMapper;
import com.billion.lagola.member.service.IUserRealInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 用户实名信息表
 * 服务实现类
 * </p>
 *
 * @author jobob
 * @since 2019-12-04
 */
@Service
public class UserRealInfoServiceImpl extends ServiceImpl<UserRealInfoMapper, UserRealInfo> implements IUserRealInfoService {

    @Resource
    UserRealInfoMapper userRealInfoMapper;

    @Override
    public UserRealInfo getByUserId(Long userId) {
        LambdaQueryWrapper<UserRealInfo> lambda = new QueryWrapper<UserRealInfo>().lambda();
        lambda.eq(UserRealInfo::getUserId, userId);
        return userRealInfoMapper.selectOne(lambda);
    }
}
