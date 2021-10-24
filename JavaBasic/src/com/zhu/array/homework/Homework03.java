package com.zhu.array.homework;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/10/23 10:31
 * @description:
 */
public class Homework03 {
    public static void main(String[] args) {
        //待排序数组
        int[] arr = {2, 4, 8, 6, 1,7};
        bubbleSort(arr);
        //遍历验证
        for (int i : arr) {
            System.out.print(i+"\t");
        }
    }

    /**
     * 冒泡排序
     *
     * @param arr
     */
    public static void bubbleSort(int[] arr) {
        int temp;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
