package com.zhu.oop2.encap;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/10/2 22:15
 * @description:
 */
public class Encapsulation01 {
    public static void main(String[] args) {

    }
}

class person{
    private String name;
    private int age;
    private double salary;

    public String getName() {
        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
