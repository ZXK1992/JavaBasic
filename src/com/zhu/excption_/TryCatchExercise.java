package com.zhu.excption_;

import java.util.Scanner;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/11/21 17:16
 * @description:
 */
public class TryCatchExercise {
    /*
    如果用户输入的不是一个整数，就提示他反复输入，直到输入一个整数为止
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            System.out.println("请输入一个整数：");
            String num = scanner.next();
            try {
                Integer.parseInt(num);
                break;
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
    }
}
