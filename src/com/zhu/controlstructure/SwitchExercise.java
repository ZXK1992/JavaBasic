package com.zhu.controlstructure;

import java.util.Scanner;

public class SwitchExercise {
    public static void main(String[] args) {

        //使用switch把小写类型的char型转为大写（键盘录入）。只转换 a,b,c,d,e,其他的输出“other“
        System.out.println("请输入一个字母的字符进行大写转换（a-e）:");
        Scanner scanner = new Scanner(System.in);
        char c = scanner.next().charAt(0);
        switch (c) {
            case 'a':
                System.out.println('A');
                break;
            case 'b':
                System.out.println('B');
                break;
            case 'c':
                System.out.println('C');
                break;
            case 'd':
                System.out.println('D');
                break;
            case 'e':
                System.out.println('E');
                break;
            default:
                System.out.println("other");
        }


    }
}
