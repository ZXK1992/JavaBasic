package com.zhu.oop2.homework.homework5;

/**
 * 员工类
 */
public class Employee {
    private String name;
    private double sal;
    private int month;

    public Employee(String name, double sal, int month) {
        this.name = name;
        this.sal = sal;
        this.month = month;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void printSalary() {
        System.out.println(getName()+"的年薪："+getSal()*getMonth());
    }

}
