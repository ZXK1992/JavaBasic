package com.zhu.oop.homework;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/10/25 23:02
 * @description:
 */
public class Homework08 {
    int count=9;
    public void count1(){
        count=10;
        System.out.println("count1="+count);
    }
    public void count2(){
        System.out.println("count1="+count);
    }

    public static void main(String[] args) {
        /*
        1.new Homework08()是匿名对象，匿名对象使用后，就不能使用
        2.  new Homework08().count1();创建好匿名对象后，就调用count1（）；
         */
        new Homework08().count1();
        Homework08 t1 = new Homework08();
        t1.count2();
        t1.count2();

    }
}
