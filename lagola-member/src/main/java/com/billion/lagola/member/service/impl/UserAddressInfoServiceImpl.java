package com.billion.lagola.member.service.impl;

import com.billion.lagola.member.entity.UserAddressInfo;
import com.billion.lagola.member.mapper.UserAddressInfoMapper;
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
    private UserAddressInfoMapper userAddressInfoMapper;

//    public void demo(){
//        userAddressInfoMapper.
//    }

}
