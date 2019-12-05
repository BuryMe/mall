package com.billion.lagola.member.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.billion.lagola.member.entity.UserAddressInfo;
import com.billion.lagola.member.entity.UserBankInfo;
import com.billion.lagola.member.mapper.UserAddressInfoMapper;
import com.billion.lagola.member.mapper.UserBankInfoMapper;
import com.billion.lagola.member.req.BasePageReq;
import com.billion.lagola.member.service.IUserBankInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.nio.file.OpenOption;
import java.util.Optional;

/**
 * <p>
 * 用户银行卡信息表 服务实现类
 * </p>
 *
 * @author jobob
 * @since 2019-12-04
 */
@Service
public class UserBankInfoServiceImpl extends ServiceImpl<UserBankInfoMapper, UserBankInfo> implements IUserBankInfoService {

    @Resource
    UserBankInfoMapper userBankInfoMapper;

    @Override
    public IPage<UserBankInfo> getPageByUserId(BasePageReq basePageReq) {
        LambdaQueryWrapper<UserBankInfo> lambdaQueryWrapper = new QueryWrapper<UserBankInfo>().lambda();
        lambdaQueryWrapper.eq(UserBankInfo::getUserId, basePageReq.getUserId());
        IPage<UserBankInfo> page = new Page<>(basePageReq.getPageNo(), basePageReq.getPageSize());
        return userBankInfoMapper.selectPage(page, lambdaQueryWrapper);
    }
}
