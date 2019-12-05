package com.billion.lagola.member.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.billion.lagola.member.entity.UserQuotaInfo;
import com.billion.lagola.member.mapper.UserQuotaInfoMapper;
import com.billion.lagola.member.service.IUserQuotaInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.billion.lagolacommon.exception.DaoException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 用户额度信息表 服务实现类
 * </p>
 *
 * @author jobob
 * @since 2019-12-04
 */
@Slf4j
@Service
public class UserQuotaInfoServiceImpl extends ServiceImpl<UserQuotaInfoMapper, UserQuotaInfo> implements IUserQuotaInfoService {

    @Resource
    UserQuotaInfoMapper quotaInfoMapper;

    @Override
    public List<UserQuotaInfo> getByUserId(Long userId) {
        LambdaQueryWrapper<UserQuotaInfo> lambda = new QueryWrapper<UserQuotaInfo>().lambda();
        lambda.eq(UserQuotaInfo::getUserId, userId);
        try {
            return quotaInfoMapper.selectList(lambda);
        } catch (Exception e) {
            log.error("userId:{},用户额度信息查询异常", userId, e);
            throw new DaoException("用户额度信息查询失败");
        }
    }
}
