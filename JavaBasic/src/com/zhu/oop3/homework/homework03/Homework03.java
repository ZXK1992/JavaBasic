package com.zhu.oop3.homework.homework03;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/11/15 11:19
 * @description:
 */
public class Homework03 {
    /*
    按要求实现下列问题：
    1.动物类Animal包含抽象方法shout();
    2.Cat类继承Animal，并实现shout，打印"猫会喵喵叫"
    2.Dog类继承Animal，并实现shout，打印"狗会汪汪叫"
    3.在测试类中实例化对象Animal cat = new Cat()，并调用cat的shout方法
    3.在测试类中实例化对象Animal dog = new Dog()，并调用dog的shout方法
     */
    public static void main(String[] args) {
        Animal cat = new Cat();
        cat.shout();
        Animal dog = new Dog();
        dog.shout();
    }
}
