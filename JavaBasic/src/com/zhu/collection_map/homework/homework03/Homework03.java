package com.zhu.collection_map.homework.homework03;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/12/14 13:23
 * @description:
 */
public class Homework03 {
    /*
    1)使用HashMap类实例化一个Map类型的对象m,键（String）和值（int）分别用于存储员工
    工的姓名和工资，存入数据如下：jack-650元；tom-1200元；Smith-2900元；
    2）将jack的工资改为2600元；
    3）为所有员工工资加薪100元；
    4）遍历集合所有员工
    5）遍历集合中所有的工资
     */
    public static void main(String[] args) {
        Map m = new HashMap();
        m.put("jack", 650);
        m.put("tom", 1200);
        m.put("smith", 2900);
        m.put("jack", 2600);
        for (Object o : m.keySet()) {
            int i = (int) m.get(o);
            m.put(o,i+100);
        }

        System.out.println("所有员工");
        for (Object o : m.keySet()) {
            System.out.println((String) o+"-"+m.get(o));
        }

        System.out.println("所有员工工资");
        for (Object o : m.keySet()) {
            System.out.println(((int)m.get(o)));
        }
    }
}
