package com.zhu.oop3.homework.homework05;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/11/15 11:38
 * @description:
 */
public class Homework05 {
    /*
    内部类
    1.编写一个类A。在类中定义局部内部类B,B中有一个私有final常量，有一个方法
    show()打印常量name，进行测试
    2.进阶：A中也定义一个私有的变量name，在show方法中打印测试
     */
    public static void main(String[] args) {
        A a = new A();
        a.useB();

    }
}
