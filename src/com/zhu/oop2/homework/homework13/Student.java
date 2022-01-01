package com.zhu.oop2.homework.homework13;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/11/9 10:49
 * @description:
 */
public class Student extends Person {
    private String stu_id;//学号

    //特有方法
    public void study() {
        System.out.println("我承诺，我会好好学习");
    }

    @Override
    public String printInfo() {
        return super.printInfo()+
                "\n学号：" + stu_id;
    }

    @Override
    public String play() {
        return getName()+"爱玩足球";
    }

    public String getStu_id() {
        return stu_id;
    }

    public void setStu_id(String stu_id) {
        this.stu_id = stu_id;
    }

    public Student(String name, char sex, int age, String stu_id) {
        super(name, sex, age);
        this.stu_id = stu_id;
    }
}
