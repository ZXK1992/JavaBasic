package com.zhu.oop.homework;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/10/25 0:56
 * @description:
 */
public class Homewrk13 {
    public static void main(String[] args) {

        PassObject passObject = new PassObject();
        Circle02 circle02 = new Circle02();
        passObject.printAreas(circle02, 5);
    }
}

/**
 * 将对象作为参数传递给方法
 * 题目要求：
 * 1.定义一个Circle02类，包含一个double型的radius属性代表圆半径，
 * findArea（）方法返回圆的面积
 * 2.定义一个类PassObject，在类中定义一个方法printAreas(),该方法的定义如下
 * public void printAreas(Circle02 c, int times) //方法的签名/声明
 * 3.在printAreas方法中打印输出1到times之间的每个整数半径值，以及对应的面积。
 * 例如，times为5 ，则输出半径1,2,3,4,5， 以及对应 的圆面积
 * 4.在main方法中调用printAreas（）方法，调用完毕后输出当前半径值
 */
class Circle02 {
    double radius;


    /**
     * 面积
     */
    public double findArea(Circle02 circle02) {
        double area = Math.PI * circle02.radius * circle02.radius;
        return area;
    }

    public void setRadius(int i) {
        this.radius = i;
    }
}

class PassObject {
    public void printAreas(Circle02 c, int times) {
        System.out.println("Radius\tArea");
        for (int i = 1; i <= times; i++) {
            // c.r=i;
            c.setRadius(i);
            double area = c.findArea(c);
            System.out.println((double) i + "  \t" + area);
        }
    }
}