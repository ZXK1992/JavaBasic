package com.zhu.collection_map.collection_.list_;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/11/27 18:14
 * @description:
 */
public class ListExercise {
    /*
    添加10个以上的元素（比如String "hello")，在2号位插入一个元素"韩顺平教育"
    获取第5个元素，删除第6个元素，修改第7个元素，再使用迭代器遍历
    集合，要求：使用List的实现类ArrayList完成
     */
    public static void main(String[] args) {
        List list = new ArrayList();
        for (int i = 10; i > 0; i--) {
            list.add("hello");
        }
       list.add(1,"韩顺平教育");
        System.out.println("第5个元素="+list.get(4));
        list.remove(5);
        list.set(6,"朱小康");
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            System.out.println(next);
        }

    }
}
