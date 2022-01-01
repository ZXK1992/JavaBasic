package com.zhu.controlstructure;

public class MulForExercise04 {
    public static void main(String[] args) {
        //打印菱形
        int size = 3;
        for (int i = 1; i <= size; i++) {
            for (int k = 1; k <= size - i; k++) {
                System.out.print(" ");
            }
            for (int k = 1; k <= 2 * i - 1; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for (int i = 1; i <= size - 1; i++) {
            for (int k = 1; k <= i; k++) {
                System.out.print(" ");
            }
            for (int k = 1; k <= 2*size - (2 * i + 1); k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}

