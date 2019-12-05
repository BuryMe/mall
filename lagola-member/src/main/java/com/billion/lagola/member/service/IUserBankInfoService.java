package com.billion.lagola.member.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.billion.lagola.member.entity.UserBankInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.billion.lagola.member.req.BasePageReq;

/**
 * <p>
 * 用户银行卡信息表 服务类
 * </p>
 *
 * @author jobob
 * @since 2019-12-04
 */
public interface IUserBankInfoService extends IService<UserBankInfo> {

    public IPage<UserBankInfo> getPageByUserId(BasePageReq basePageReq);

}
