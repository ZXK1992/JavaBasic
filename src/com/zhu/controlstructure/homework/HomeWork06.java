package com.zhu.controlstructure.homework;

public class HomeWork06 {
    public static void main(String[] args) {
/*
求1+(1+2)+(1+2+3)+...+(1+...100)
*/
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            sum+=(int)((i*(i+1))/2.0);
        }
        System.out.println(sum);
    }

}
