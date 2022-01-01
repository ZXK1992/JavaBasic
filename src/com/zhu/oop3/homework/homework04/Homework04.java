package com.zhu.oop3.homework.homework04;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/11/15 11:25
 * @description:
 */
public class Homework04 {
    /*
        //考察对匿名内部类的使用
        1.计算器接口具有work方法，功能是运算，有一个手机类Cellphone,定义方法testWork
        测试计算功能，调用计算接口的work方法
        2.要求调用Cellphone对象的testWork方法，使用上匿名内部类
     */
    public static void main(String[] args) {
        Cellphone cellphone = new Cellphone();
        cellphone.testWork(new ICalculator() {
            @Override
            public double work(double n1, double n2) {
                return n1 + n2;
            }
        }, 10, 9);
    }
}
