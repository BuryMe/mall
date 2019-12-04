package com.billion.lagola.member.entity;

import java.time.LocalDateTime;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户额度信息表
 * </p>
 *
 * @author jobob
 * @since 2019-12-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="UserQuotaInfo对象", description="用户额度信息表")
public class UserQuotaInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    @ApiModelProperty(value = "用户号")
    private Long userId;

    @ApiModelProperty(value = "资方编号")
    private Long fundId;

    @ApiModelProperty(value = "资方名称")
    private String fundName;

    @ApiModelProperty(value = "额度类型（1：信贷类型额度）")
    private Integer quotaType;

    @ApiModelProperty(value = "额度状态（1：可用）")
    private Integer quotaStatus;

    @ApiModelProperty(value = "总额度（单位分）")
    private Long quotaTotal;

    @ApiModelProperty(value = "可用额度（单位分）")
    private Long quotaAvailable;

    @ApiModelProperty(value = "额度到期时间")
    private LocalDateTime quotaExpireTime;


}
