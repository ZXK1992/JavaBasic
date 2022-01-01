package com.zhu.collection_map.collection_.list_;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/11/27 18:29
 * @description:
 */
public class ListFor {
    /*
    List的三种遍历方式（ArrayList、LinkedList和Vector）
    1）方式一：使用Iterator
    Iterator iterator = list.iterator();
    while(iterator.hasNext()){
    Object obj = iterator.next();
    }
    2)方式二：使用增强for
    for(Object obj:list){
    }
    3)方式三：使用普通for
     for (int i = 0; i < list.size(); i++) {
            Object o = list.get(i);
            System.md.out.println(o);
        }
     */
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("nmf");
        System.out.println("迭代器");
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            System.out.println(next);
        }
        System.out.println("增强for");
        for (Object o : list) {
            System.out.println(o);
        }
        System.out.println("普通for");
        for (int i = 0; i < list.size(); i++) {
            Object o = list.get(i);
            System.out.println(o);
        }

    }
}
