package com.zhu.oop2.poly_.polyarr_;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/11/5 17:54
 * @description:
 */
public class Teacher extends Person {
    private double salary;

    public Teacher(String name, int age, double salary) {
        super(name, age);
        this.salary = salary;
    }
    //重写父类的 say 方法
    @Override
    public String say() {
        return "老师 " + super.say() + " salary=" + salary;
    }
    //特有方法
    public void teach() {
        System.out.println("老师 " + getName() + " 正在讲 java 课程...");
    }

}
