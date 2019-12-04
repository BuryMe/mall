package com.billion.lagola.member.enums;

import com.baomidou.mybatisplus.core.enums.IEnum;

public enum BankCardEnums implements IEnum<Integer> {
    /**
     * 储蓄卡
     */
    ONE(1, "储蓄卡"),

    /**
     * 信用卡
     */
    TOW(2, "信用卡");

    private Integer value;
    private String desc;

    BankCardEnums(int i, String 储蓄卡) {
    }

    @Override
    public Integer getValue() {
        return null;
    }
}
