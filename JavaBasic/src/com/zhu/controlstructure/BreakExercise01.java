package com.zhu.controlstructure;

public class BreakExercise01 {
    public static void main(String[] args) {
        //1-100以内的数求和，求出当和第一次大于20的当前数
        int sum = 0;
        for (int i = 1; i <=100; i++) {
           sum += i;
           if (sum>20){
               System.out.printf("当前数="+i);
               break;
           }
        }
    }
}
