package com.zhu.oop.homework;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/10/25 0:51
 * @description:
 */
public class Homework12 {
    public static void main(String[] args) {

    }
}

/**
 * 创建一个类，属性有（名字，性别，年龄，职位，薪水），提供
 * 3个构造方法，可以初始化（1）（名字，性别，年龄，职位，薪水）。
 * （2）（名字，性别，年龄）（3）（职位，薪水），要求充分复用构造器
 */
class Employee {
    String name;
    char sex;
    int age;
    String position;
    double salary;

    //构造器复用
    public Employee(String name, char sex, int age, String position, double salary) {
//        this.md.name = name;
//        this.md.sex = sex;
//        this.md.age = age;
        this(name, sex, age);
        this.position = position;
        this.salary = salary;
    }

    public Employee(String name, char sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public Employee(String position, double salary) {
        this.position = position;
        this.salary = salary;
    }
}