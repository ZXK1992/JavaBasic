package com.zhu.collection_map.collection_.set_.hashset;

import java.util.HashSet;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/10/19 9:48
 * @description:
 */
public class HashSet01 {
    public static void main(String[] args) {

        //1. 构造器走的源码
/*
public HashSet() {
map = new HashMap<>();
}
2. HashSet 可以存放 null ,但是只能有一个 null,即元素不能重复

 */
        HashSet set = new HashSet();
        set.add(null);
        set.add(null);
        System.out.println("set="+set);
    }
}
