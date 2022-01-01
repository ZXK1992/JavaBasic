package com.zhu.oop3.homework.homework02;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/11/15 11:07
 * @description:
 */
public class TestFrock {
    public static void main(String[] args) {
        System.out.println("第一次调用：" + Frock.getNextNum());
        System.out.println("第二次调用：" + Frock.getNextNum());
        Frock frock1 = new Frock();
        System.out.println(frock1.getSerialNumber());
        Frock frock2 = new Frock();
        System.out.println(frock2.getSerialNumber());
        Frock frock3 = new Frock();
        System.out.println(frock3.getSerialNumber());

    }
}
