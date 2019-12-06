package com.billion.lagola.member;

/**
 * 懒汉单例模式
 *
 * @Auther: fusw
 * @Date: 2019-12-06 14:54
 * @Description:
 */
public class SingleTest2 {

    private SingleTest2() {
    }

    private static SingleTest2 single;

//    线程安全
    public synchronized SingleTest2 getSingle() {
        if (single == null) {
            return new SingleTest2();
        } else {
            return single;
        }
    }


}
