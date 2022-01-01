package com.zhu.oop.homework;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/10/24 23:40
 * @description:
 */
public class Homework05 {
    public static void main(String[] args) {
        Circle circle = new Circle(3);
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
     double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    /**
     * 显示周长
     */
    public void showPerimeter(){
        double perimeter = Math.PI*2*radius;
        System.out.println("圆周长="+perimeter);
    }

    /**
     * 显示面积
     */
    public void showArea(){
        double area = Math.PI*radius*radius;
        System.out.println("圆面积="+area);
    }
}