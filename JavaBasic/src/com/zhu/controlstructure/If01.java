package com.zhu.controlstructure;

import java.util.Scanner;

public class If01 {
    public static void main(String[] args) {
        System.out.println("请输入保国同志的芝麻信用分：");
        Scanner scanner = new Scanner(System.in);
        int creScore = scanner.nextInt();
        if (creScore == 100) {
            System.out.println("信用极好");
        } else if (creScore > 80 && creScore <= 99) {
            System.out.println("信用优秀");
        } else if (creScore >= 60 && creScore <= 80) {
            System.out.println("信用一般");
        } else {
            System.out.println("信用不及格");
        }
    }
}
