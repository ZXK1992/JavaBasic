package com.zhu.collection_map.collection_;

import com.zhu.collection_map.entity.Dog;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/11/26 21:43
 * @description:
 */
public class CollectionExercise {
    public static void main(String[] args) {
        Dog d1 = new Dog("小黄", 1);
       Dog d2 = new Dog("小黑",2)  ;
        Dog d3 =new Dog("小花",3) ;
        List list = new ArrayList();
        list.add(d1);
        list.add(d2);
        list.add(d3);
        //迭代器遍历
        Iterator iterator = list.iterator();
        System.out.println("迭代器" );
        while (iterator.hasNext()) {
            Object next = iterator.next();
            System.out.println(next);
        }
        System.out.println("增强for" );
        for (Object o : list) {
            System.out.println(o);
        }

    }
}
