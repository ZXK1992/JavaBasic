package com.zhu.collection_map.collection_;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/10/18 18:16
 * @description:
 */
public class ColltionExercise {
    /**
     * 请编写程序
     * 1.创建3个 Dog( name, age) 对象，放入到ArrayList中。赋给List引用
     * 2.用迭代器和增强for循环两种方式来遍历
     * 3.重写Dog的tostring方法
     * @param args
     */
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        Dog xiaobai = new Dog("小白", 1);
        Dog xiaohuang=  new Dog("小黄",2);
        Dog xiaohua= new Dog("小花",3);
        List list = new ArrayList();
        list.add(xiaobai);
        list.add(xiaohuang);
        list.add(xiaohua);
        System.out.println("============迭代器");
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Dog next =(Dog) iterator.next();
            System.out.println(next);
        }
        System.out.println("============增强for");
        for (Object o : list) {
            System.out.println(o);
        }

    }
}
class Dog{
    private String name;
    private int age;

    public Dog(String name, int age) {
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

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
