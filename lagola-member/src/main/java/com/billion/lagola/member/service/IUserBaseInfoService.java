package com.billion.lagola.member.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.billion.lagola.member.entity.UserBaseInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.billion.lagola.member.req.UserBaseInfoReq;

/**
 * <p>
 * 用户信息表 服务类
 * </p>
 *
 * @author jobob
 * @since 2019-12-04
 */
public interface IUserBaseInfoService extends IService<UserBaseInfo> {

    IPage<UserBaseInfo> getPageByParam(UserBaseInfoReq userBaseInfoReq);

}
