package com.zhu.io_.packaging_flow.obiect_;

import java.io.Serializable;

/**
 * @author: ZHUXIAOKANG
 * @date: 2022/1/8 14:07
 * @description:
 */
public class Dog implements Serializable {
    private static final long serialVersionUID = 4137075802040849792L;
    //    private static final long SerialVersionUID=1L;
    private String name;
    private int age;
    //序列化对象时，默认将里面所有属性都进行序列化，但除了static或transient
    //     修饰的成员
    private static String nation;
    private transient String color;

    public Dog(String name, int age,String nation ,String color) {
        this.name = name;
        this.age = age;
        this.nation=nation;
        this.color = color;
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


    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +",nation="+nation+
                ", color='" + color + '\'' +
                '}';
    }
}
