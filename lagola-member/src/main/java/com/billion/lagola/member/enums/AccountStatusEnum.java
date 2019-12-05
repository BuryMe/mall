package com.billion.lagola.member.enums;


import com.baomidou.mybatisplus.core.enums.IEnum;

/**
 * 用户账号状态
 */
public enum AccountStatusEnum implements IEnum<Integer> {

    /**
     * 账号 正常使用
     */
    activation(1, "正常"),

    /**
     * 账号 废弃
     */
    disuse(0, "废弃");

    private Integer value;
    private String desc;

    AccountStatusEnum(int i, String 储蓄卡) {
    }


    @Override
    public Integer getValue() {
        return this.value;
    }
}
