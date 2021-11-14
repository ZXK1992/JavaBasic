package com.zhu.oop2.homework.homework13;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/11/9 10:53
 * @description:
 */
public class Person {
    private String name;
    private char sex;
    private int age;
public String play(){
    return getName()+"爱玩";
}
    public Person(String name, char sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public String printInfo() {
        return
                "姓名：" + name + "\n" +
                "年龄：" + age +"\n"+
                "性别：" + sex;
    }
}
