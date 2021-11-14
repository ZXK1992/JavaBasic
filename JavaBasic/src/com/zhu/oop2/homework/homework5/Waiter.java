package com.zhu.oop2.homework.homework5;

/**
 * 服务生
 */
class Waiter extends Employee {
    public Waiter(String name, double sal, int month) {
        super(name, sal, month);
    }

    @Override
    public void printSalary() {
        System.out.print("服务生 ");
        super.printSalary();
    }
}
