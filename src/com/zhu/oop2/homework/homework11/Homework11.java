package com.zhu.oop2.homework.homework11;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/11/9 10:33
 * @description:
 */
public class Homework11 {
    public static void main(String[] args) {
        //向上转型：父类引用指向子类对象
        Person person = new Student();
        person.run();
        person.eat();
        //向下转型：把指向子类对象的父类引用，转成指向子类对象的子类引用
        Student student =(Student)person;
        student.study();
        student.eat();
        student.run();
    }
}
/*
现有Person类，里面有方法run,eat ,Student类继承了Person
并重写run方法,自定义study方法，试写出对象向上转型和向下转型
的代码，并写出各自都可以调用哪些方法，并写出方法输出什么？
 */
class Person{
    public void run(){
        System.out.println("preson run");
    }
    public void eat(){
        System.out.println("preson eat");
    }
}
class Student extends Person{
    @Override
    public void run(){
        System.out.println("stu run");
    }
    public void study(){
        System.out.println("stu study");
    }
}