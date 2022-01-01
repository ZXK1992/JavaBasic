package com.zhu.oop3.interface_;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/11/18 10:51
 * @description:
 */
public interface IA {
    //jdk8后接口加default关键字有方法体
    default void m1(){
        System.out.println("Color.java");
    };

    //jdk8后接口加static关键字有方法体
     static void m2(){
        System.out.println("Color.java");
    };
}
