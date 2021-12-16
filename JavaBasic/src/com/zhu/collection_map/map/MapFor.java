package com.zhu.collection_map.map;

import java.util.*;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/12/8 9:09
 * @description:
 */
@SuppressWarnings({"all"})
public class MapFor {
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("邓超", "孙俪");
        map.put("王宝强", "马蓉");
        map.put("宋喆", "马蓉");
        map.put("刘令博", null);
        map.put(null, "刘亦菲");
        map.put("鹿晗", "关晓彤");
        //第一组；先取出所有key,通过key取出对应的value
        Set set = map.keySet();
        //增强for
        System.out.println("增强for");
        for (Object key : set) {
            System.out.println(key + "-" + map.get(key));
        }
        //迭代器
        System.out.println("迭代器");
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Object key = iterator.next();
            System.out.println(key + "-" + map.get(key));
        }

        //第二组： 把所有的values取出来
        Collection values = map.values();
        //这里可以使用所有的Collection使用的遍历方法
        //增强for
        System.out.println("取出所有value增强for");
        for (Object value : values) {
            System.out.println(value);
        }

        //(2) 迭代器
        System.out.println("---取出所有的 value 迭代器----");
        Iterator iterator2 = values.iterator();
        while (iterator2.hasNext()) {
            Object value = iterator2.next();
            System.out.println(value);
        }

        //第三组：entrySet来获取k-v
        Set entrySet = map.entrySet();//EntrySet<Map.Entry<K,V>>
        //1）增强for
        System.out.println("使用EntrySet的增强for");
        for (Object entry : entrySet) {
            //将entry转成Map.Entry
            Map.Entry entry1 = (Map.Entry) entry;
            System.out.println(entry1.getKey()+"-"+entry1.getValue());

        }

        //迭代器
        System.out.println("使用EntrySet的迭代器");
        Iterator iterator1 = entrySet.iterator();
        while (iterator1.hasNext()) {
            Object entry = iterator1.next();
            System.out.println(entry.getClass());
            Map.Entry m = (Map.Entry) entry;
            System.out.println(m.getKey() + "-" + m.getValue());



        }
    }
}
