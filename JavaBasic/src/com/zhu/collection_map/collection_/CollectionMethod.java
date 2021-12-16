package com.zhu.collection_map.collection_;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/11/26 20:30
 * @description:
 */
public class CollectionMethod {

    public static void main(String[] args) {
        List list = new ArrayList();
        //add:添加单个元素
        list.add("zxxk");
        list.add(10);
        list.add(true);
        System.out.println(list);
        // remove:删除指定元素
        //list.remove(0);//删除第一个元素
        list.remove(true);//指定删除某个元素
        System.out.println("list=" + list);
        // contains:查找元素是否存在
        System.out.println(list.contains("zxxk"));//T
        // size:获取元素个数
        System.out.println(list.size());//2
        //isEmpty判断是否为空
        System.out.println(list.isEmpty());//F
        //clear:清空
        //list.clear();
        System.out.println(list);
        //addAll:添加多个元素
        ArrayList list2 = new ArrayList();
        list2.add("nmb");
        list2.add("ndy");
        list.addAll(list2);
        System.out.println(list);
       // containsAll:查找多个元素是否都存在
        System.out.println(list.containsAll(list2));//T
        // removeAll：删除多个元素
        list.add("聊斋");
        list.removeAll(list2);
        System.out.println("list=" + list);//[聊斋]
        // 说明：以 ArrayList 实现类来演示.

    }

}
