package com.billion.lagola.member.service;

import com.billion.lagola.member.entity.UserQuotaInfo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 用户额度信息表 服务类
 * </p>
 *
 * @author jobob
 * @since 2019-12-04
 */
public interface IUserQuotaInfoService extends IService<UserQuotaInfo> {

    public List<UserQuotaInfo> getByUserId(Long userId) throws Exception;

}
