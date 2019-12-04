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
 * 用户实名信息表
 *
 * </p>
 *
 * @author jobob
 * @since 2019-12-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "UserRealInfo对象", description = "用户实名信息表")
public class UserRealInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    private LocalDateTime createDate;

    private LocalDateTime updateDate;

    @ApiModelProperty(value = "用户号")
    private Long userId;

    @ApiModelProperty(value = "用户姓名")
    private String name;

    @ApiModelProperty(value = "性别。0：女性。1：男性")
    private Integer sex;

    @ApiModelProperty(value = "国家/地区")
    private String contry;

    @ApiModelProperty(value = "名族")
    private String nation;

    @ApiModelProperty(value = "身份证件类型。1：身份证")
    private Integer idCardType;

    @ApiModelProperty(value = "身份证件号码")
    private String idCardNo;

    @ApiModelProperty(value = "生日")
    private LocalDateTime birthday;

    @ApiModelProperty(value = "身份证件开始时间")
    private LocalDateTime idCardStart;

    @ApiModelProperty(value = "身份证件结束时间")
    private LocalDateTime idCardEnd;

    @ApiModelProperty(value = "身份证签发地址")
    private String idCardIssueAddress;

    @ApiModelProperty(value = "身份证件签发机构")
    private String idCardIssueAgency;


}
