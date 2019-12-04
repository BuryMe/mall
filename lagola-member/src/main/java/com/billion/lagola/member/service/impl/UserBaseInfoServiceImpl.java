package com.billion.lagola.member.service.impl;

import com.billion.lagola.member.entity.UserBaseInfo;
import com.billion.lagola.member.mapper.UserBaseInfoMapper;
import com.billion.lagola.member.service.IUserBaseInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}
