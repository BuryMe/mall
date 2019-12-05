package com.billion.lagola.member.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.billion.lagola.member.entity.UserBaseInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.billion.lagola.member.req.UserBaseInfoReq;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 用户信息表 Mapper 接口
 * </p>
 *
 * @author jobob
 * @since 2019-12-04
 */
public interface UserBaseInfoMapper extends BaseMapper<UserBaseInfo> {

    List<UserBaseInfo> getByParam(UserBaseInfoReq userBaseInfoReq);

    Integer countByParam(UserBaseInfoReq userBaseInfoReq);
}
