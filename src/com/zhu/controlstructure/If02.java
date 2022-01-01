package com.zhu.controlstructure;

import java.util.Scanner;

public class If02 {
    public static void main(String[] args) {
        System.out.println("请输入成绩和性别：");
        Scanner scanner = new Scanner(System.in);
        double score = scanner.nextDouble();
        char gender = scanner.next().charAt(0);
        if (score > 8.0) {
            if (gender == '男') {
                System.out.println("进入男子组决赛");
            } else if (gender == '女') {
                System.out.println("进入男子组决赛");
            }else {
                System.out.println("输入的性别不合法");
            }
        } else {
            System.out.println("淘汰");
        }
    }
}
