package com.billion.lagola.member.resp;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @Auther: fusw
 * @Date: 2019-12-05 16:04
 * @Description:
 */
@Data
public class UserBaseResp {

    private Long userId;

    private String name;

    private String mobile;

    private String idCardNo;

    private Integer status;

    private String createDate;


}
