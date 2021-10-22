package com.zhu.controlstructure;

import java.util.Scanner;

public class DoWhileExercise03 {
    public static void main(String[] args) {
        //如果李三不还钱，则老韩将一直使出五连鞭，直到李三说还钱为止
        //思路分析
        //化繁为简
        //(1) 不停的问还钱吗？
        //2  使用char anwser 接收回答，定义Scanner 对象
        //3 在do while 的while 判断如果是y就不再循环
        char anwser = ' ';
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("老韩将使出五连鞭");
            System.out.println("老韩问:还钱吗（（y/n）：");
             anwser = scanner.next().charAt(0);
            System.out.println("李三的回答："+anwser);
        }while (anwser != 'y');
        System.out.println("李三还钱了");
    }
}
