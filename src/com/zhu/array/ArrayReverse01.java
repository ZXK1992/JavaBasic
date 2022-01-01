package com.zhu.array;


import java.lang.reflect.Array;

public class ArrayReverse01 {
    public static void main(String[] args) {
        //数组反转
        //方式1
        //int [] arr = {1,2,3,4,5}
        //arr[0]-> arr[5]
        //arr[1]-> arr[4]
        //arr[2]-> arr[3]
        //交换了3次
        int [] arr = {1,2,3,4,5};
        for (int i = 0; i < arr.length/2; i++) {
          int  temp = arr[i];
            arr[i] = arr[arr.length-i-1];
            arr[arr.length-i-1] = temp;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+"\t");
        }

    }
}
