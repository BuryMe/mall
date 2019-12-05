package com.billion.lagola.member.service;

import com.billion.lagola.member.entity.UserRealInfo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户实名信息表
 服务类
 * </p>
 *
 * @author jobob
 * @since 2019-12-04
 */
public interface IUserRealInfoService extends IService<UserRealInfo> {

    public UserRealInfo getByUserId(Long userId);

}
