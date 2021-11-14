package com.zhu.oop2.homework;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/10/27 10:53
 * @description:
 */
class Homework04 {
    public static void main(String[] args) {
        Worker worker = new Worker("jack", 400, 22, 1.0);

        worker.printSalary();
        Manager manager = new Manager("zxk",450,22,1.2);
        manager.setBonus(1000);
        manager.printSalary();
    }
}
/**
 * 通过继承实现员工工资核算打印功能
 * 父类：员工类（Employee）
 * 子类：部门经理（Manager）、普通员工类（Worker）
 * (1)部门经理工资=1000+单日工资*天数*等级（1.2）=>奖金+基本工资
 * (2)普通员工工资=单日工资*天数*等级（1.0）
 * (3)员工属性：姓名，单日工资，工作天数
 * （4）员工方法 （打印工资）
 * 5. 普通员工及部门经理都是员工子类，需要重写打印工资方法
 * 6.定义并初始化普通员工对象，调用打印工资方法输出工资，定义并初始化部门
 * 经理对象，调用打印工资方法输出工资
 */

/**
 * 员工类
 */
class Employee {
    private String name;//姓名
    private double dailySalary;//单日工资
    private int workDays;//工作天数
    private double grade;//此属性也为公有属性，等级

    public Employee(String name, double dailySalary, int workDays, double grade) {
        this.name = name;
        this.dailySalary = dailySalary;
        this.workDays = workDays;
        this.grade = grade;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public void printSalary() {
        System.out.println(getName()+"工资=" + getDailySalary()*getWorkDays()*getGrade());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDailySalary() {
        return dailySalary;
    }

    public void setDailySalary(double dailySalary) {
        this.dailySalary = dailySalary;
    }

    public int getWorkDays() {
        return workDays;
    }

    public void setWorkDays(int workDays) {
        this.workDays = workDays;
    }
}

/**
 * 部门经理
 */
class Manager extends Employee {
    private double bonus;//奖金是该类特有的属性
    public Manager(String name, double dailySalary, int workDays, double grade) {
        super(name, dailySalary, workDays, grade);
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public void printSalary() {
        System.out.println("部门经理 "+getName()+"工资="
                + (bonus + getDailySalary()*getWorkDays()*getGrade()));
    }
}

/**
 * 普通员工
 */
class Worker extends Employee {
    public Worker(String name, double dailySalary, int workDays, double grade) {
        super(name, dailySalary, workDays, grade);
    }
    @Override
    public void printSalary() {
        System.out.print("普通员工  ");
              super.printSalary();
    }
}