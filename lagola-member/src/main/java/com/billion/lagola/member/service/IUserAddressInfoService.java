package com.billion.lagola.member.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.billion.lagola.member.entity.UserAddressInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.billion.lagola.member.req.BasePageReq;

/**
 * <p>
 * 用户收货地址信息表 服务类
 * </p>
 *
 * @author jobob
 * @since 2019-12-04
 */
public interface IUserAddressInfoService extends IService<UserAddressInfo> {

    public IPage<UserAddressInfo> getPageByUserId(BasePageReq basePageReq);

}
