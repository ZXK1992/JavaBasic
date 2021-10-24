package com.zhu.oop.homework;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/10/5 9:43
 * @description:
 */
public class Homework01 {
    public static void main(String[] args) {
        A01 a01 = new A01();
        double [] arr = {1,1.2,0.8,5.0};
        System.out.println(a01.max(arr));;
    }
}

/**
 * 编写类A01，定义方法max，实现求某个double数组的最大值，并返回
 */
class A01{
    //求double数组最大值
     public double max(double[] arr){
         double max = 0;
         for (int i = 0; i < arr.length; i++) {
             max = max > arr[i] ? max:arr[i];
         }
         return max;
     }
}