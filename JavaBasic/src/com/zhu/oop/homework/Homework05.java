package com.zhu.oop.homework;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/10/24 23:40
 * @description:
 */
public class Homework05 {
    public static void main(String[] args) {
        Circle circle = new Circle();
        circle.setR(3);
        //周长
        circle.showPerimeter();
        //面积
        circle.showArea();
    }
}

/**
 * 定义一个圆类Circle,定义属性：半径，提供显示圆周长功能的方法，
 * 提供显示圆面积的方法
 */
class Circle{
    private double r;

    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
    }

    /**
     * 显示周长
     */
    public void showPerimeter(){
        double r = this.getR();
        double perimeter = Math.PI*2*r;
        System.out.println("圆周长="+perimeter);
    }

    /**
     * 显示面积
     */
    public void showArea(){
        double r = this.getR();
        double area = Math.PI*r*r;
        System.out.println("圆面积="+area);
    }
}