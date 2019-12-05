package com.billion.lagola.member.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.billion.lagola.member.entity.UserIntegralInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.billion.lagola.member.req.BasePageReq;

import java.util.List;

/**
 * <p>
 * 用户积分表 服务类
 * </p>
 *
 * @author jobob
 * @since 2019-12-04
 */
public interface IUserIntegralInfoService extends IService<UserIntegralInfo> {

    IPage<UserIntegralInfo> getPageByUserId(BasePageReq basePageReq);

}
