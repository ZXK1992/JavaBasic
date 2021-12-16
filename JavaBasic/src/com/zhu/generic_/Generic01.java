package com.zhu.generic_;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/12/14 22:26
 * @description:
 */
public class Generic01 {
    /*
    1)编写程序，在ArrayList中，添加3个Dog对象
    2）Dog对象含有name，和age，并输出name和age（要求使用getXXX（）；
     */
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Dog("a",1));
        arrayList.add(new Dog("b",2));
        arrayList.add(new Dog("c",3));
        //假如我们的程序员，不小心，添加了一只猫
        arrayList.add(new Cat("招财猫", 8));
        for (Object o : arrayList) {
            System.out.println("姓名"+((Dog)o).getName()+"年龄"+((Dog)o).getAge());
        }

    }
}
class Dog{
        private String name;
    private int age;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
class Cat{
    private String name;
    private int age;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}