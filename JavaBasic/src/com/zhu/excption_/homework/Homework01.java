package com.zhu.excption_.homework;

import java.util.Scanner;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/11/1 23:53
 * @description:
 */
public class Homework01 {
    public static void main(String[] args) {
        if (args.length != 2) {
            throw new ArrayIndexOutOfBoundsException("缺少命令行参数");
        }
        String s1 = args[0];
        String s2 = args[1];
        try {
            int n1 = Integer.parseInt(s1);
            int n2 = Integer.parseInt(s2);
            cal(n1, n2);
        } catch (NumberFormatException e) {
            System.out.println("数据格式不正确");
        }

    }


    /**
     * a)编写应用程序EcmDef.java，接收命令行的两个参数（整数），计算两数相除。
     * b）计算两数相除，要求使用方法cal(int n1,int n2)
     * c)对数据格式不正确（NumberFormatException）、缺少命令行参数
     * （ArrayIndexOutOfBoundsException）、除0进行异常处理（ArithmeticException）。
     */

    public static void cal(int n1, int n2) {

        try {
            double res = n1 / n2;
            System.out.println("计算结果=" + res);
        } catch (ArithmeticException e) {
            System.out.println("除数不能为0");
        }

    }

}
