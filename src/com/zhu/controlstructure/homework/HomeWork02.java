package com.zhu.controlstructure.homework;

public class HomeWork02 {
    public static void main(String[] args) {
/*
    判断一个整数是否是水仙花数，所谓水仙花数是指一个3位数，其各个位上数字立方和等于其本身
    例如： 153=1*1*1+5*5*5+3*3*3
*/
        int num = 111;
        if ((num/100)*(num/100)*(num/100)
             +(num%100/10)*(num%100/10)*(num%100/10)
                +(num%10)*(num%10)*(num%10)==num){
            System.out.println("该数是水仙花数");
        }else {
            System.out.println("该数不是水仙花数");
        }

    }
}
