package com.zhu.collection_map.homework.homework2;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/12/14 9:52
 * @description:
 */
public class Homework02 {
    /*
    使用ArrayList完成对对象Car(name,price)的各种操作
    1.add添加单个元
    2.remove删除指定元素
    3.contains：查找元素是否存在
    4.size获取元素个数
    5.isEmpty判断是否为空
    6.clear清空
    7.addAll添加多个元素
    8.containsAll查找多个元素是否多存在
    9.removeAll删除多个元素
    使用增强for和迭代器来遍历所有car，需要重写Car的toString
     */
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
        Car car = new Car("宝马", 400000);
        Car car2 = new Car("宾利", 500000);
        Car car3 = new Car("奔驰", 450000);
        Car car4 = new Car("丰田", 150000);
        Car car5 = new Car("五菱", 50000);
        arrayList.add(car);
        arrayList.add(car2);
        arrayList.add(car3);
        arrayList.add(car4);
        arrayList.add(car5);
        System.out.println("添加完后");
        System.out.println("arrayList="+arrayList);
        arrayList.remove(car);
        System.out.println("删除完后");
        System.out.println("arrayList="+arrayList);
        System.out.println(arrayList.contains(car));
        System.out.println(arrayList.contains(car2));
        System.out.println("元素个数="+arrayList.size());
        System.out.println(arrayList.isEmpty());
       /* arrayList.clear();
        System.md.out.println(arrayList.isEmpty());*/
        Car car6 = new Car("丰田", 150000);
        Car car7 = new Car("五菱", 50000);
        ArrayList list = new ArrayList();
        list.add(car6);
        list.add(car7);
        arrayList.addAll(list);
        System.out.println("添加list完后");
        System.out.println(arrayList.containsAll(list));
//        System.md.out.println(arrayList.removeAll(list));
        //增强for
        System.out.println("增强for");
        for (Object o : arrayList) {
            System.out.println((Car)o);
        }

        //迭代器
        System.out.println("迭代器");
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            System.out.println((Car)next);
        }
    }
}
