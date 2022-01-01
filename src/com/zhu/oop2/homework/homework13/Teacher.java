package com.zhu.oop2.homework.homework13;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/11/9 10:51
 * @description:
 */
public class Teacher extends Person {
    private int work_age;//工龄
    //特有方法
    public void teach() {
        System.out.println("我承诺，我会认真教学");
    }

    @Override
    public String play() {
        return  getName()+"爱下象棋";
    }

    public int getWork_age() {
        return work_age;
    }

    public void setWork_age(int work_age) {
        this.work_age = work_age;
    }

    public Teacher(String name, char sex, int age, int work_age) {
        super(name, sex, age);
        this.work_age = work_age;
    }

    @Override
    public String printInfo () {
        return super.printInfo()+
                "\n工龄：" + work_age;
    }
}
