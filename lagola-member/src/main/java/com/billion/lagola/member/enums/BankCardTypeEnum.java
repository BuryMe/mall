package com.billion.lagola.member.enums;

import com.baomidou.mybatisplus.core.enums.IEnum;

public enum BankCardTypeEnum implements IEnum<Integer> {
    /**
     * 储蓄卡
     */
    debitCard(1, "储蓄卡"),

    /**
     * 信用卡
     */
    creditCard(2, "信用卡");

    private Integer value;
    private String desc;

    BankCardTypeEnum(int i, String 储蓄卡) {
    }

    @Override
    public Integer getValue() {
        return this.value;
    }
}
