package com.zhu.design_patterns.danli;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/11/17 19:50
 * @description:懒汉式
 */
public class Singleton02 {
    //2.私有化单例对象
    private static Singleton02 singleton02;

    //1.构造器私有化，防止直接new
    private Singleton02() {
    }

    //3.提供公共的get对象方法
    //
    public static Singleton02 getInstance() {
        if (singleton02 == null) {//如果还没有创建singleton02对象
            singleton02 = new Singleton02();
        }
        return singleton02;
    }
}

