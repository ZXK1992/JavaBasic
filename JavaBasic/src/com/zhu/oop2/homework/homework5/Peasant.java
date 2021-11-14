package com.zhu.oop2.homework.homework5;

/**
 * 农民类
 */
class Peasant extends Employee {
    public Peasant(String name, double sal, int month) {
        super(name, sal, month);
    }

    @Override
    public void printSalary() {
        System.out.print("农民 ");
        super.printSalary();
    }
}
