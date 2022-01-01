package com.zhu.controlstructure;

public class WhileExercise {
    public static void main(String[] args) {
        //打印1~100之间所有是3的倍数的整数
        int start = 1;
        int end = 100;
        int t =3;
        while((start <= end)){
            if (start % t == 0){
                System.out.println(start);
            }
            start++;
        }
        System.out.println("=============================");
        // 打印40-200的偶数
        int s2 = 40;
        int e2= 200;
        while((s2 <= e2)){
            if (s2 % 2 == 0){
                System.out.println(s2);
            }
            s2++;
        }
    }


}
