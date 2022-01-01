package com.zhu.excption_.homework;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/11/1 23:53
 * @description:
 */
public class Homework04 {
    //输出结果：BCD
    public static void main(String[] args) {
        try {
            showExce();
            System.out.println("A");
        } catch (Exception e) {
            System.out.println("B");
        } finally {
            System.out.println("C");
        }
        System.out.println("D");
    }


    public static void showExce() throws Exception {
        throw new Exception();
    }

}
