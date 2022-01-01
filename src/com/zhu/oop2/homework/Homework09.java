package com.zhu.oop2.homework;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/11/7 21:48
 * @description:
 */
public class Homework09 {
    public static void main(String[] args) {
        LabeledPoint black = new LabeledPoint("Black", 1929, 230.07);
        System.out.println("标签值："+black.getLabeled()+",x坐标："+black.getX()
                +",y坐标:"+black.getY());
    }
}

class Point{
    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
}

class LabeledPoint extends Point{
    private String labeled;

    public LabeledPoint(String labeled,double x, double y) {
        super(x, y);
        this.labeled=labeled;
    }

    public String getLabeled() {
        return labeled;
    }

    public void setLabeled(String labeled) {
        this.labeled = labeled;
    }

}
