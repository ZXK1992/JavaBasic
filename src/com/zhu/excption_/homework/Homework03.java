package com.zhu.excption_.homework;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/11/1 23:53
 * @description:
 */
public class Homework03 {
    //输出结果：BCD
    public static void main(String[] args) {

        try {
            func();
        } catch (Exception e) {
            System.out.println("C");
        }

        System.out.println("D");
    }

    public static void func() {
        try {
            throw new RuntimeException();
        } finally {
            System.out.println("B");
        }
    }
}
