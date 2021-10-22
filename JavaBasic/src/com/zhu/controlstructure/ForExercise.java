package com.zhu.controlstructure;

public class ForExercise {
    public static void main(String[] args) {
        //打印1~100之间所有是9的倍数的整数，统计个数及总和
        int count = 0;
        int sum = 0;
        int start = 1;
        int end = 100;
        int t = 9;
        for (int i = start; i <= end; i++) {
            if (i % t == 0) {
                count++;
                sum += i;
            }
        }
        System.out.println("总数=" + count);
        System.out.println("总和=" + sum);


    }


}
