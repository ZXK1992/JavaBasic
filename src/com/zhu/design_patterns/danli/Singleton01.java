package com.zhu.design_patterns.danli;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/11/17 10:16
 * @description: 饿汉式
 */
public class Singleton01 {
    //2.在类的内部创建对象
    //为了能够在静态方法中返回singleton01,需要将其修饰static
    //对象，通常是重量级的对象，饿汉式可能造成创建对象，但没使用
    private static  Singleton01 singleton01 = new Singleton01();

    //1.构造器私有化，防止直接new
    private Singleton01() {
    }

    //3.提供公共的get对象方法
    public static Singleton01 getInstance() {
        return singleton01;
    }
}