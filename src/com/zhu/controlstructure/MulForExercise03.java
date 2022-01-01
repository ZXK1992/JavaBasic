package com.zhu.controlstructure;

import java.util.Scanner;

public class MulForExercise03 {
    public static void main(String[] args) {
        //打印空心金字塔
        int totalLevel=100;
        for (int i = 1; i <= totalLevel; i++) {
            for (int k = 1; k <= totalLevel - i; k++) {
                System.out.print(" ");
            }
            for (int k = 1; k <= 2 * i - 1; k++) {
                if (k == 1 || k == 2 * i - 1 || i == totalLevel) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
