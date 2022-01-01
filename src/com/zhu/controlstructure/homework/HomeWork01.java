package com.zhu.controlstructure.homework;

public class HomeWork01 {
    public static void main(String[] args) {
        //某人有100000元，每次经过一次路口，需要缴费，规则如下
        //当现金>50000每次交5%
        //当现金<=50000时，每次交1000
        //  编程计算该人可以经过多少次路口，要求使用while break方式完成
        double money = 100000;//该人有的现金
         int count = 0;//经过的路口数
        while(true){
            if(money > 50000){
                money = money*0.95;
                count++;
            }else if(money > 1000){
                money-=1000;
                count++;
            }else {
                break;
            }

        }
        System.out.println("剩余"+money+"元");
        System.out.println("该人可以经过"+count+"次路口");
    }
}
