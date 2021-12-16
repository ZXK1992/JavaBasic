package com.zhu.collection_map.homework.homework05;

import com.zhu.collection_map.homework.homework05.Person;

import java.util.TreeSet;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/12/14 17:31
 * @description:
 */
public class Homework05 {
    public static void main(String[] args) {
        TreeSet treeSet = new TreeSet();
        //分析源码
        //add方法，因为TreeSet()构造器没有传入Comparator接口的匿名对象
        //所以底层Comparable<? super K> k=(Comparable<? super K>) key;
        //即把Person转成comparable类型
        treeSet.add(new Person());//ClassCastException
        treeSet.add(new Person());
        treeSet.add(new Person());//
        System.out.println(treeSet);
        /*
        结局方案Person实现Comparable，并重写compareTo,如果返回0，就去重
         */
    }
}
