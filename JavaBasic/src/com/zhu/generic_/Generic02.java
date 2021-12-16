package com.zhu.generic_;

import java.util.ArrayList;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/12/14 22:26
 * @description:
 */
public class Generic02 {
    /*
    1)编写程序，在ArrayList中，添加3个Dog对象
    2）Dog对象含有name，和age，并输出name和age（要求使用getXXX（）；
     */
    public static void main(String[] args) {
        //使用传统的方法来解决===> 使用泛型
        //老韩解读
        //1. 当我们 ArrayList<Dog> 表示存放到 ArrayList 集合中的元素是 Dog 类型 (细节后面说...)
        //2. 如果编译器发现添加的类型，不满足要求，就会报错
        //3. 在遍历的时候，可以直接取出 Dog 类型而不是 Object
        //4. public class ArrayList<E> {} E 称为泛型,那么 Dog->E
        //Dog不是泛型，是把Dog指定给了E
        ArrayList<Dog> arrayList = new ArrayList<>();
        arrayList.add(new Dog("a",1));
        arrayList.add(new Dog("b",2));
        arrayList.add(new Dog("c",3));
        for (Dog o : arrayList) {
            System.out.println("姓名"+o.getName()+"年龄"+o.getAge());
        }
    }
}


