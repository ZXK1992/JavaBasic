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
        System.out.println(cale.getDivision(cale));
        System.out.println("===========================");
        Cale cale2 = new Cale(2, 0);
        System.out.println(cale2.getSum(cale2));
        System.out.println(cale2.getMinus(cale2));
        System.out.println(cale2.getMult(cale2));
        System.out.println(cale2.getDivision(cale2));
    }
}

/**
 * 编程创建一个Cale计算类，在其中定义2个变量表示两个操作数，定义四个方法方分别
 * 实现求和、差、乘、商（要求除数为0的话，要提示）并创建两个对象、分别测试
 */
class Cale{
    private double a;
    private double b;

    /**
     * 求和
     * @param cale
     * @return
     */
    public double getSum(Cale cale){
       return cale.getA()+cale.getB();
    }

    /**
     * 求差
     * @param cale
     * @return
     */
    public double getMinus(Cale cale){
        return cale.getA()-cale.getB();
    }

    /**
     *乘法
     * @param cale
     * @return
     */
    public double getMult(Cale cale){
        return cale.getA()*cale.getB();
    }

    /**
     * 除法
     * @param cale
     * @return
     */
    public double getDivision(Cale cale){
       if (cale.getB()==0){
           throw new RuntimeException("除数不能为0");
       }
       return cale.getA()/cale.getB();
    }
    public Cale(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }
}