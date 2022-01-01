package com.zhu.controlstructure;

import java.util.Scanner;

public class SwitchExercise03 {
    public static void main(String[] args) {
//根据用户指定的月份，打印该月所属季节，3,4,5春季，6,7,8夏季，9,10,11秋，12,1,2冬季
        System.out.println("请输入月份【1-12】");
        Scanner scanner = new Scanner(System.in);
        int month = scanner.nextInt();

            switch (month){
                case 3:
                case 4:
                case 5:
                    System.out.println("春季");
                    break;
                case 6:
                case 7:
                case 8:
                    System.out.println("夏季");
                    break;
                case 9:
                case 10:
                case 11:
                    System.out.println("秋季");
                    break;
                case 12:
                case 1:
                case 2:
                    System.out.println("冬季");
                    break;
                default:
                    System.out.println("输入的月份不对，在【1-12】");
            }

    }
}
