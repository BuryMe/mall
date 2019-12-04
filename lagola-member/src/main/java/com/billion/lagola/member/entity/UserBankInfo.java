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
 * 用户银行卡信息表
 * </p>
 *
 * @author jobob
 * @since 2019-12-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="UserBankInfo对象", description="用户银行卡信息表")
public class UserBankInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    @ApiModelProperty(value = "用户号")
    private Long userId;

    @ApiModelProperty(value = "银行名称")
    private String bankName;

    @ApiModelProperty(value = "银行编码")
    private String bankCode;

    @ApiModelProperty(value = "银行卡号")
    private Long bankCardNo;

    @ApiModelProperty(value = "银行卡类型。1：储蓄卡。2：信用卡")
    private Integer bankCardType;

    @ApiModelProperty(value = "银行卡预留手机号")
    private Integer bankCardMobileNo;

    @ApiModelProperty(value = "信用卡CVV码")
    private Integer cvv;

    @ApiModelProperty(value = "信用卡到期日")
    private String expire;


}
