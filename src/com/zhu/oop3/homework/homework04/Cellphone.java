package com.zhu.oop3.homework.homework04;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/11/15 11:28
 * @description:
 */
public class Cellphone {
    public void testWork(ICalculator iCalculator,double n1,double n2){
        double result = iCalculator.work(n1, n2);
        System.out.println("运算结果="+result);
    }
}
