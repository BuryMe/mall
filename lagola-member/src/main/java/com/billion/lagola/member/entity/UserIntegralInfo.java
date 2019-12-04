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
 * 用户积分表
 * </p>
 *
 * @author jobob
 * @since 2019-12-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="UserIntegralInfo对象", description="用户积分表")
public class UserIntegralInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    private LocalDateTime createDate;

    private LocalDateTime updateDate;

    @ApiModelProperty(value = "用户号")
    private Long userId;

    @ApiModelProperty(value = "积分值")
    private Integer integralValue;

    @ApiModelProperty(value = "积分操作。0：减去积分。1：增加积分")
    private Integer operate;

    @ApiModelProperty(value = "用户总积分")
    private Integer integralTotal;

    @ApiModelProperty(value = "积分来源")
    private String source;


}
