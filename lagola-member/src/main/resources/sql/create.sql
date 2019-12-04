# table:lagola_member

CREATE TABLE `user_address_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `user_id` bigint(32) NOT NULL COMMENT '用户号',
  `name` varchar(10) COLLATE utf8_bin NOT NULL COMMENT '收货人名字',
  `mobile_no` varchar(20) COLLATE utf8_bin NOT NULL COMMENT '收货人联系方式（可手机，带区号座机）',
  `province` varchar(10) COLLATE utf8_bin NOT NULL COMMENT '省份/直辖市',
  `city` varchar(10) COLLATE utf8_bin NOT NULL COMMENT '城市',
  `district` varchar(10) COLLATE utf8_bin NOT NULL COMMENT '区县',
  `address_detail` varchar(100) COLLATE utf8_bin NOT NULL COMMENT '详细地址',
  `postcode` int(20) DEFAULT NULL COMMENT '邮编',
  `default_flag` int(1) NOT NULL COMMENT '是否为默认地址 。1：是。0：不是',
  PRIMARY KEY (`id`),
  KEY `idx_user_id` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='用户收货地址信息表';


CREATE TABLE `user_bank_info` (
  `id` bigint(32) NOT NULL AUTO_INCREMENT,
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `user_id` bigint(32) NOT NULL COMMENT '用户号',
  `bank_name` varchar(20) COLLATE utf8_bin NOT NULL COMMENT '银行名称',
  `bank_code` varchar(10) COLLATE utf8_bin NOT NULL COMMENT '银行编码',
  `bank_card_no` bigint(20) NOT NULL COMMENT '银行卡号',
  `bank_card_type` int(1) NOT NULL COMMENT '银行卡类型。1：储蓄卡。2：信用卡',
  `bank_card_mobile_no` int(11) NOT NULL COMMENT '银行卡预留手机号',
  `cvv` int(10) DEFAULT NULL COMMENT '信用卡CVV码',
  `expire` varchar(10) COLLATE utf8_bin DEFAULT NULL COMMENT '信用卡到期日',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `idx_card_no` (`bank_card_no`) USING BTREE,
  KEY `idx_user_id` (`user_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='用户银行卡信息表';


CREATE TABLE `user_base_info` (
  `id` bigint(32) NOT NULL AUTO_INCREMENT,
  `create_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `user_id` bigint(32) NOT NULL COMMENT '用户号',
  `user_login` varchar(30) COLLATE utf8_bin NOT NULL COMMENT '用户登录账号',
  `user_password` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '用户登录密码',
  `status` int(1) NOT NULL DEFAULT '1' COMMENT '用户状态（1.表示正常；0：表示废弃）',
  `token` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '用户登录token',
  `source` int(2) NOT NULL DEFAULT '0' COMMENT '注册来源。1：lagola',
  `mobile` int(11) NOT NULL COMMENT '用户手机号',
  `email` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '邮箱',
  `credit_level` int(2) DEFAULT NULL COMMENT '信用等级',
  `nick_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '昵称',
  `app_level` int(2) DEFAULT NULL COMMENT '用户app等级',
  PRIMARY KEY (`id`,`user_id`) USING BTREE,
  UNIQUE KEY `idx_user_login` (`user_login`) USING BTREE,
  KEY `idx_mobile` (`mobile`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='用户信息表';


CREATE TABLE `user_integral_info` (
  `id` bigint(32) NOT NULL AUTO_INCREMENT,
  `create_date` datetime DEFAULT CURRENT_TIMESTAMP,
  `update_date` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `user_id` bigint(32) NOT NULL COMMENT '用户号',
  `integral_value` int(10) NOT NULL COMMENT '积分值',
  `operate` int(1) NOT NULL COMMENT '积分操作。0：减去积分。1：增加积分',
  `integral_total` int(10) NOT NULL COMMENT '用户总积分',
  `source` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '积分来源',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `idx_user_id` (`user_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='用户积分表';


CREATE TABLE `user_quota_info` (
  `id` bigint(32) NOT NULL AUTO_INCREMENT,
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `user_id` bigint(32) NOT NULL COMMENT '用户号',
  `fund_id` bigint(32) NOT NULL COMMENT '资方编号',
  `fund_name` varchar(20) COLLATE utf8_bin NOT NULL COMMENT '资方名称',
  `quota_type` int(1) NOT NULL COMMENT '额度类型（1：信贷类型额度）',
  `quota_status` int(1) NOT NULL COMMENT '额度状态（1：可用）',
  `quota_total` bigint(32) NOT NULL COMMENT '总额度（单位分）',
  `quota_available` bigint(32) NOT NULL COMMENT '可用额度（单位分）',
  `quota_expire_time` datetime DEFAULT NULL COMMENT '额度到期时间',
  PRIMARY KEY (`id`),
  KEY `idx_user_id` (`user_id`) USING BTREE,
  KEY `idx_user_id_fund_id` (`user_id`,`fund_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='用户额度信息表';


CREATE TABLE `user_real_info` (
  `id` bigint(32) NOT NULL AUTO_INCREMENT,
  `create_date` datetime DEFAULT CURRENT_TIMESTAMP,
  `update_date` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `user_id` bigint(32) NOT NULL COMMENT '用户号',
  `name` varchar(6) COLLATE utf8_bin NOT NULL COMMENT '用户姓名',
  `sex` int(1) NOT NULL COMMENT '性别。0：女性。1：男性',
  `contry` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '国家/地区',
  `nation` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '名族',
  `id_card_type` int(2) NOT NULL DEFAULT '1' COMMENT '身份证件类型。1：身份证',
  `id_card_no` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '身份证件号码',
  `birthday` datetime DEFAULT NULL COMMENT '生日',
  `id_card_start` datetime DEFAULT NULL COMMENT '身份证件开始时间',
  `id_card_end` datetime DEFAULT NULL COMMENT '身份证件结束时间',
  `id_card_issue_address` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '身份证签发地址',
  `id_card_issue_agency` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '身份证件签发机构',
  PRIMARY KEY (`id`,`user_id`,`id_card_no`) USING BTREE,
  UNIQUE KEY `idx_id_card_no` (`id_card_no`) USING BTREE,
  UNIQUE KEY `idx_id_card_info` (`id_card_no`,`id_card_type`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='用户实名信息表\n';