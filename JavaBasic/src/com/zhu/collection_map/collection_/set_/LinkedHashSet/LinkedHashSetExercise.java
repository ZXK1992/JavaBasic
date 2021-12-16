package com.zhu.collection_map.collection_.set_.LinkedHashSet;

import java.util.LinkedHashSet;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/12/7 16:57
 * @description:
 */
@SuppressWarnings({"all"})
public class LinkedHashSetExercise {
    /*
    Car类（属性：name,price）。如果name和price相同，则认为是
    相同元素就不能添加

     */
    public static void main(String[] args) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.add(new Car("奥拓", 1000));//OK
        linkedHashSet.add(new Car("奥迪", 300000));//OK
        linkedHashSet.add(new Car("法拉利", 10000000));//OK
        linkedHashSet.add(new Car("奥迪", 300000));//加入不了
        linkedHashSet.add(new Car("保时捷", 70000000));//OK
        linkedHashSet.add(new Car("奥迪", 300000));//加入不了
        System.out.println("linkedHashSet="+linkedHashSet);
    }
}
