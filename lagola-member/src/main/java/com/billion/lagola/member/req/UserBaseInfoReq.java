package com.billion.lagola.member.req;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Auther: fusw
 * @Date: 2019-12-05 15:24
 * @Description:
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UserBaseInfoReq extends BasePageReq {

    private String name;

    private String mobileNo;

    private String idCardNo;


}
