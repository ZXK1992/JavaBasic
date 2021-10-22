package com.zhu.controlstructure.homework;

public class HomeWork05 {
    public static void main(String[] args) {
/*
求1-1/2+1/3-1/4...1/100
*/
        double sum = 0;
        for (int i = 1; i <= 50; i++) {
            if (i==1){
                sum= 1.0/(i*(i+1));
                System.out.println(sum);
            }else {
                sum+=1.0/((2*i-1)*2*i);
            }
        }
        System.out.println("和为："+sum);
    }

}
