package com.zhu.array.sort;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/9/28 22:54
 * @description:
 */
public class BubbleSort {
    public static void main(String[] args) {
        //冒泡排序
        int temp = 0;
        int [] arr = {1,3,7,5,8};
        for (int i = 0 ; i < arr.length-1 ; i++){
           for (int j=0;j<arr.length-1-i;j++){
               if (arr[j]>arr[j+1]){
                  temp = arr[j] ;
                   arr[j]=arr[j+1];
                   arr[j+1]=temp;
               }
           }
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+"\t");
        }

    }
}
