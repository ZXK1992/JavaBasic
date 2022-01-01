package com.zhu.collection_map.collection_.list_.arraylist_;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/10/18 20:48
 * @description:
 */
public class ListExercise {
/**
 * 添加10个以上的元素（比如string “hello“），在2号位插入一个元素”韩顺平教育“
 * ，获得第5个元素，删除第6个元素，修改第7个元素，在使用迭代器遍历集合，
 * 要求：使用List的实现类ArrayList完成
 *
 */
public static void main(String[] args) {
    ArrayList list = new ArrayList();
    for (int i = 0; i < 12; i++) {
        list.add("hello");
    }
    list.add(1,"韩顺平教育");
    Object o = list.get(4);
    System.out.println("第五个元素："+o );
    list.remove(5);
    list.set(6,"zxk");
    Iterator iterator = list.iterator();
    while (iterator.hasNext()) {
        Object next = iterator.next();
        System.out.println(next);
    }
}
}
