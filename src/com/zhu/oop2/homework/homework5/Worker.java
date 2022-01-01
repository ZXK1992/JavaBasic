package com.zhu.oop2.homework.homework5;

/**
 * 工人类
 */
public class Worker extends Employee {
    public Worker(String name, double sal, int month) {
        super(name, sal, month);
    }

    @Override
    public void printSalary() {
        System.out.print("工人 ");
        super.printSalary();
    }
}
