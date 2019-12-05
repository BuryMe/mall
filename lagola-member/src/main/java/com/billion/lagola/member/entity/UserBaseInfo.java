package com.billion.lagola.member.entity;

import java.time.LocalDateTime;
import java.io.Serializable;

import com.billion.lagola.member.enums.AccountStatusEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户信息表
 * </p>
 *
 * @author jobob
 * @since 2019-12-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "UserBaseInfo对象", description = "用户信息表")
public class UserBaseInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    private LocalDateTime createDate;

    private LocalDateTime updateDate;

    @ApiModelProperty(value = "用户号")
    private Long userId;

    @ApiModelProperty(value = "用户登录账号")
    private String userLogin;

    @ApiModelProperty(value = "用户登录密码")
    private String userPassword;

    @ApiModelProperty(value = "用户状态（1.表示正常；0：表示废弃）")
    private Integer status;

    @ApiModelProperty(value = "用户登录token")
    private String token;

    @ApiModelProperty(value = "注册来源。1：lagola")
    private Integer source;

    @ApiModelProperty(value = "用户手机号")
    private String mobile;

    @ApiModelProperty(value = "邮箱")
    private String email;

    @ApiModelProperty(value = "信用等级")
    private Integer creditLevel;

    @ApiModelProperty(value = "昵称")
    private String nickName;

    @ApiModelProperty(value = "用户app等级")
    private Integer appLevel;


}
