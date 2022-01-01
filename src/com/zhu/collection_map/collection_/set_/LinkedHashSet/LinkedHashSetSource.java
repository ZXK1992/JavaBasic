package com.zhu.collection_map.collection_.set_.LinkedHashSet;

import java.util.LinkedHashSet;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/12/6 20:21
 * @description:
 */
public class LinkedHashSetSource {
    public static void main(String[] args) {
        LinkedHashSet set = new LinkedHashSet();
        set.add(new String("AA"));
        set.add(456);
        set.add(456);
        set.add(new Customer("刘",1001));
        set.add(123);
        set.add("HSP");
        System.out.println("set="+set);

    }

}
