package com.zhu.oop2.homework.homework5;

/**
 * 教师
 * 教师除基本工资外，还有课酬（元/天）classDay classSal
 */
class Teacher extends Employee {
    private int classDay;
    private double classSal;

    public Teacher(String name, double sal, int month) {
        super(name, sal, month);
    }

    @Override
    public void printSalary() {
        System.out.print("老师 ");
        System.out.println(getName()+"的年薪："+(getSal()*getMonth()+classSal*classDay));
    }

    public int getClassDay() {
        return classDay;
    }

    public void setClassDay(int classDay) {
        this.classDay = classDay;
    }

    public double getClassSal() {
        return classSal;
    }

    public void setClassSal(double classSal) {
        this.classSal = classSal;
    }
}
