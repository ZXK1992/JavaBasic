package com.zhu.controlstructure;

import java.util.Scanner;

public class SwitchExercise02 {
    public static void main(String[] args) {
        System.out.println("请输入学生成绩【0-100】");
        Scanner scanner = new Scanner(System.in);
        double nextDouble = scanner.nextDouble();
        if (nextDouble >=0 && nextDouble <=100){
            switch ((int) (nextDouble/60)){
                case 0:
                    System.out.println("不及格");
                    break;
                case 1:
                    System.out.println("及格");
                    break;
            }
        }else {
            System.out.println("学生成绩在【0-100】");
        }
    }
}
