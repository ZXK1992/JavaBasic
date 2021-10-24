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

class Employee{
    String name;
    char sex;
    int age;
    String position;
    double salary;

    public Employee(String name, char sex, int age, String position, double salary) {
        this.name = name;
        this.sex = sex;
        this.age = age;
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