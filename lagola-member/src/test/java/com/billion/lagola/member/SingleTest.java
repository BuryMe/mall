package com.billion.lagola.member;

/**
 * 饿汉单例
 *
 * @Auther: fusw
 * @Date: 2019-12-06 14:53
 * @Description:
 */
public class SingleTest {

    private static SingleTest single = new SingleTest();

    private SingleTest() {

    }

    public SingleTest getSingle() {
        return single;
    }

}
