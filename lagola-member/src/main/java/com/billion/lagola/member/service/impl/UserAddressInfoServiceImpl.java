package com.billion.lagola.member.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.billion.lagola.member.entity.UserAddressInfo;
import com.billion.lagola.member.entity.UserBankInfo;
import com.billion.lagola.member.mapper.UserAddressInfoMapper;
import com.billion.lagola.member.req.BasePageReq;
import com.billion.lagola.member.service.IUserAddressInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 用户收货地址信息表 服务实现类
 * </p>
 *
 * @author jobob
 * @since 2019-12-04
 */
@Service
public class UserAddressInfoServiceImpl extends ServiceImpl<UserAddressInfoMapper, UserAddressInfo> implements IUserAddressInfoService {

    @Resource
    UserAddressInfoMapper userAddressInfoMapper;

    @Override
    public IPage<UserAddressInfo> getPageByUserId(BasePageReq basePageReq) {
        LambdaQueryWrapper<UserAddressInfo> lambdaQueryWrapper = new QueryWrapper<UserAddressInfo>().lambda();
        lambdaQueryWrapper.eq(UserAddressInfo::getUserId, basePageReq.getUserId());
        IPage<UserAddressInfo> page = new Page<>(basePageReq.getPageNo(), basePageReq.getPageSize());
        return userAddressInfoMapper.selectPage(page, lambdaQueryWrapper);
    }



}
