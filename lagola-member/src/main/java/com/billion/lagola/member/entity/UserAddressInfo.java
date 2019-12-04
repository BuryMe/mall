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
 * 用户收货地址信息表
 * </p>
 *
 * @author jobob
 * @since 2019-12-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="UserAddressInfo对象", description="用户收货地址信息表")
public class UserAddressInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    @ApiModelProperty(value = "用户号")
    private Long userId;

    @ApiModelProperty(value = "收货人名字")
    private String name;

    @ApiModelProperty(value = "收货人联系方式（可手机，带区号座机）")
    private String mobileNo;

    @ApiModelProperty(value = "省份/直辖市")
    private String province;

    @ApiModelProperty(value = "城市")
    private String city;

    @ApiModelProperty(value = "区县")
    private String district;

    @ApiModelProperty(value = "详细地址")
    private String addressDetail;

    @ApiModelProperty(value = "邮编")
    private Integer postcode;

    @ApiModelProperty(value = "是否为默认地址 。1：是。0：不是")
    private Integer defaultFlag;


}
