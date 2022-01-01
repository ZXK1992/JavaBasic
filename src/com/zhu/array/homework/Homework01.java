package com.zhu.array.homework;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/9/30 9:04
 * @description:
 */
public class Homework01 {
    public static void main(String[] args) {
        /*
        已知有个升序的数组，要求插入一个元素，该数组顺序依然是升序，比如
        [10,12,45,90] 添加23后，数组为[10,12,23,45,90]
        思路： 本质数组扩容 + 定位
        1. 我们现确定添加数应该插入到那个索引
        2.然后扩容
         */

        int[] arr = {10, 12, 45, 90};
        int insertNum = 23;//需要添加的数
        int index = -1;//记录这个数需要添加到数组arr的下标位置
        int[] arrNew = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            //定位
            if (insertNum < arr[i]) {
                index = i;
                break;
            }
        }
        if (index == -1){
            index = arr.length;
        }

        //扩容
        //i表示新数组的下标，j表示旧的
        for (int i = 0, j = 0; i < arrNew.length; i++) {
            if (i !=index){
                arrNew[i] = arr[j];
                j++;
            }else {
                arrNew[i] = insertNum;
            }
        }
        arr = arrNew;

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }
}
