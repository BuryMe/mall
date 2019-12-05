package com.billion.lagola.member.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.billion.lagola.member.entity.UserBaseInfo;
import com.billion.lagola.member.mapper.UserBaseInfoMapper;
import com.billion.lagola.member.req.UserBaseInfoReq;
import com.billion.lagola.member.service.IUserBaseInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * <p>
 * 用户信息表 服务实现类
 * </p>
 *
 * @author jobob
 * @since 2019-12-04
 */
@Service
public class UserBaseInfoServiceImpl extends ServiceImpl<UserBaseInfoMapper, UserBaseInfo> implements IUserBaseInfoService {

    @Resource
    UserBaseInfoMapper userBaseInfoMapper;

    @Override
    public IPage<UserBaseInfo> getPageByParam(UserBaseInfoReq userBaseInfoReq) {
        IPage<UserBaseInfo> iPage = new Page<>();
        iPage.setCurrent(userBaseInfoReq.getPageNo());
        iPage.setSize(userBaseInfoReq.getPageSize());
        userBaseInfoReq.setPageNo(userBaseInfoReq.getPageSize() > 0 ? (userBaseInfoReq.getPageNo() - 1) * userBaseInfoReq.getPageSize() : 0);
        return iPage.setRecords(userBaseInfoMapper.getByParam(userBaseInfoReq)).setTotal(userBaseInfoMapper.countByParam(userBaseInfoReq));
    }
}
