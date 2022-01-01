package com.zhu.oop.homework;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/10/25 0:26
 * @description:
 */
public class Homework07 {
    public static void main(String[] args) {
        Dog dog = new Dog("小黄","黄色",5);
        dog.show();
    }
}

class Dog{
    public String name;
    public String color;
    public int age;

    public Dog(String name, String color, int age) {
        this.name = name;
        this.color = color;
        this.age = age;
    }

    public void show(){
        System.out.println("狗的名字="+this.name+",狗的颜色="+this.color+",狗的年龄="+this.age+"岁。");
    }



}