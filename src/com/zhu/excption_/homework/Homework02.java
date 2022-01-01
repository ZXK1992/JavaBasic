package com.zhu.excption_.homework;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/11/1 23:53
 * @description:
 */
public class Homework02 {
    public static void main(String[] args) {
        if (args[4].equals("john")){//可能发生空指针
            System.out.println("AA");
        }else {
            System.out.println("BB");
        }
        Object obj = args[2];//String.md->Object ,向上转型
        Integer i = (Integer) obj;//错误，这里一定发生ClassCastException

    }
}
