package com.zhu.collection_map.homework.homework06;

import java.util.HashSet;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/12/14 17:37
 * @description:
 */
public class Homework06 {
    public static void main(String[] args) {
        HashSet set = new HashSet();
        Person p1 = new Person(1001, "AA");
        Person p2 = new Person(1002, "BB");
        set.add(p1);
        set.add(p2);
        p1.name="CC";
        set.remove(p1);
        System.out.println(set);
        set.add(new Person(1001,"CC"));
        System.out.println(set);
        set.add(new Person(1001,"AA"));
        System.out.println(set);
    }
}