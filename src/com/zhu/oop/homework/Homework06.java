package com.zhu.oop.homework;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/10/24 23:40
 * @description:
 */
public class Homework06 {
    public static void main(String[] args) {
        Cale cale = new Cale(2, 3);
        System.out.println(cale.getSum(cale));
        System.out.println(cale.getMinus(cale));
        System.out.println(cale.getMult(cale));
        Double div = cale.getDiv(cale);
        if (div != null) {
            System.out.println(div);
        }

        System.out.println("===========================");
        Cale cale2 = new Cale(2, 0);
        System.out.println(cale2.getSum(cale2));
        System.out.println(cale2.getMinus(cale2));
        System.out.println(cale2.getMult(cale2));
        Double div2 = cale2.getDiv(cale2);
        if (div2 != null) {
            System.out.println(div2);
        }

    }
}

/**
 * 编程创建一个Cale计算类，在其中定义2个变量表示两个操作数，定义四个方法方分别
 * 实现求和、差、乘、商（要求除数为0的话，要提示）并创建两个对象、分别测试
 */
class Cale {
    double a;
    double b;

    /**
     * 求和
     *
     * @param cale
     * @return
     */
    public double getSum(Cale cale) {
        return cale.a + cale.b;
    }

    /**
     * 求差
     *
     * @param cale
     * @return
     */
    public double getMinus(Cale cale) {
        return cale.a - cale.b;
    }

    /**
     * 乘法
     *
     * @param cale
     * @return
     */
    public double getMult(Cale cale) {
        return cale.a * cale.b;
    }

    /**
     * 除法
     *
     * @param cale
     * @return
     */
    public Double getDiv(Cale cale) {
        if (cale.b == 0) {
            System.out.println("b不能为0");
            return null;
        }
        return cale.a / cale.b;
    }

    public Cale(double a, double b) {
        this.a = a;
        this.b = b;
    }
}