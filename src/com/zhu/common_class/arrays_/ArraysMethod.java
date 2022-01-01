package com.zhu.common_class.arrays_;

import com.zhu.oop3.homework.homework05.A;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/11/25 11:04
 * @description:
 */
public class ArraysMethod {
    public static void main(String[] args) {
        //    1)toString 返回数组的字符串形式
        //int[] ints = new int[3];
       // char[] chars = new char[3];
        int [] arr = {1,1,1};
        String s = Arrays.toString(arr);
        System.out.println(s);
        // 2)sort排序 (自然排序和定制排序)
        Integer [] arr2 = {1,3,2};
        Arrays.sort(arr2);
        System.out.println(Arrays.toString(arr2));
        Arrays.sort(arr2, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        System.out.println(Arrays.toString(arr2));
    }
}
