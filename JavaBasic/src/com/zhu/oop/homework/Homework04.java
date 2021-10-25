package com.zhu.oop.homework;

import java.util.Arrays;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/10/24 23:25
 * @description:
 */
public class Homework04 {
    public static void main(String[] args) {
        A03 a03 = new A03();
        int[] oldArr = {1, 2, 3, 4, 5};
        int[] newArr = a03.copyArr(oldArr);
        System.out.println(Arrays.toString(newArr));
    }
}

/**
 * 编写类A03,实现数组的复制功能copyArr，输入旧数组，返回一个新数组，元素和旧数组一样
 */
class A03 {
    public int[] copyArr(int[] oldArr) {
        int[] newArr = new int[oldArr.length];
        for (int i = 0; i < oldArr.length; i++) {
            newArr[i] = oldArr[i];
        }
        return newArr;
    }
}