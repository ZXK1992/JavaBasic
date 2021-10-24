package com.zhu.oop.homework;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/10/5 9:43
 * @description:
 */
public class Homework02 {
    public static void main(String[] args) {
        A02 a02 = new A02();
        String [] arr = {"aaa","aaa","zkx"};
        String str = "aaa";
        System.out.println(a02.find(arr,str));;
    }
}

/**
 * 编写A02。定义方法find ，实现查找某字符串数组中的元素，并返回索引，找不到返回-1
 */
class A02{
    //实现查找某字符串数组中的元素，并返回索引，找不到返回-1
     public int find(String[] arr,String str){
         int index = -1;
         for (int i = 0; i < arr.length; i++) {
             if (str.equals(arr[i])){
                 index = i;
                 break;
             }
         }
         return index;
     }
}