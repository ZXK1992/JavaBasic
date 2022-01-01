package com.zhu.oop2.homework.homework5;

/**
 * 科学家
 * 科学家除基本工资外，还有年终奖bonus
 */
class Scientist extends Employee {
    private double bonus;

    public Scientist(String name, double sal, int month) {
        super(name, sal, month);
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public void printSalary() {
        System.out.print("科学家 ");
        System.out.println(getName()+"的年薪："+(getSal()*getMonth()+bonus));

    }
}
