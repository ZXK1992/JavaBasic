package com.zhu.array;


public class ArrayReverse02 {
    public static void main(String[] args) {
        //数组反转int [] arr = {1,2,3,4,5};
        //方式2
        int [] arr = {1,2,3,4,5,6};
        //定义一个新数组保存arr逆序遍历的元素
        int[] arr2 = new int[arr.length];

        for (int i = arr.length-1;i>=0;i--){
            arr2[arr.length-i-1]=arr[i];
        }
            arr =arr2;
        //遍历arr2
        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i]+"\t");
        }
        System.out.println();
        //遍历arr1
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+"\t");
        }

    }
}
