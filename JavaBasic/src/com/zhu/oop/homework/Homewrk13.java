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
        passObject.printAreas(circle02,5);
    }
}
class Circle02{
    double r;



    /**
     * 面积
     */
    public double findArea(Circle02 circle02){

        double area = Math.PI*circle02.r*circle02.r;
        return area;
    }
}

class PassObject{
   public void printAreas(Circle02 c, int times){
       System.out.println("Radius\tArea");
       for (int i = 1; i < times; i++) {
           c.r=i;
           double area = c.findArea(c);
           System.out.println(i+"\t"+area);
       }
   }
}