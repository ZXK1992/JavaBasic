package com.zhu.controlstructure;

import java.util.Scanner;

public class MulForExercise02 {
    public static void main(String[] args) {
        //打印九九乘法表
        for (int i = 1 ; i <= 9; i++ ){
            for (int j = 1 ; j <= i; j++ ){
                System.out.print(j+"x"+i+"="+(i*j)+"\t");
            }
            System.out.println();
        }
    }
}
