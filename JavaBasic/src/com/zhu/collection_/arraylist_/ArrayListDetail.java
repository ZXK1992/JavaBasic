package com.zhu.collection_.arraylist_;

import java.util.ArrayList;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/10/14 23:36
 * @description:
 */
public class ArrayListDetail {
    public static void main(String[] args) {
        //1. ArrayList 可以加入null
        //ArrayList 是线程不安全的
        ArrayList list = new ArrayList();
        for (int i = 1; i <= 10; i++) {
            list.add(i);
        }
        for (int i = 11; i <= 15; i++) {
            list.add(i);
        }
        list.add(16);
        list.add(17);
    }
}
