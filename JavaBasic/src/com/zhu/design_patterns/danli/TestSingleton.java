package com.zhu.design_patterns.danli;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/11/17 19:43
 * @description:
 */
public class TestSingleton {
    public static void main(String[] args) {
        //饿汉
        Singleton01 instance = Singleton01.getInstance();
        Singleton01 instance2 = Singleton01.getInstance();
        System.out.println(instance==instance2);
        System.out.println("-=---------------");
        //懒汉
        Singleton02 instance3 = Singleton02.getInstance();
        Singleton02 instance4 = Singleton02.getInstance();
        System.out.println(instance3==instance4);
    }
}
