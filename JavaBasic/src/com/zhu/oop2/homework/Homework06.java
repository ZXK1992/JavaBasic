package com.zhu.oop2.homework;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/11/7 20:57
 * @description:
 */
public class Homework06 {
}
class Grand{
    String name="AA";
    private int age=100;
    public void g1(){}
}

class Father extends Grand{
    String id="001";
    private double score;
    //super可以访问哪些成员（属性和方法）
    public void f1(){
        String name = super.name;
        super.g1();
        String id = this.id;
        double score = this.score;
        String name1 = this.name;
        this.g1();
        this.f1();

    }
}
class Son extends Father{
    String name="BB";
    public void g1(){}
    private void show(){
        String id = super.id;
        String name = super.name;
        super.g1();
        super.f1();
        String name1 = this.name;
        String id1 = this.id;
        this.g1();
        this.f1();
        this.show();
    }
}