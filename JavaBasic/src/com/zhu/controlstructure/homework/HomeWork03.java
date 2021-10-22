package com.zhu.controlstructure.homework;

public class HomeWork03 {
    public static void main(String[] args) {
/*
输出1-100之间的不能被5整除的数，每5个一行
*/
        int count = 0;//统计不能被5整除的个数
        for (int i = 1; i <= 100; i++) {
            if (i % 5 != 0) {
                System.out.print(i+"\t");
                count++;
                //判断没满5个就换行
                if (count % 5 == 0) {
                    System.out.println();
                }
            }
        }
    }

}
