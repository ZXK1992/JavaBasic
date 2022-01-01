package com.zhu.oop2.poly_.polyarr_;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/11/5 17:50
 * @description:
 */
public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String say() {//返回名字和年龄
        return name + "\t" + age;
    }
}
