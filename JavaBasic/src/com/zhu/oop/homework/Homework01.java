package com.zhu.oop.homework;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/10/5 9:43
 * @description:
 */
public class Homework01 {
    public static void main(String[] args) {
        A01 a01 = new A01();
        double[] arr = {0, 1, 2,1.5,-1,12.2};
        Double max = a01.max(arr);
        if (max != null) {
            System.out.println("arr的最大值=" + max);
        } else {
            System.out.println("arr数组不能为null或{}");
        }

    }
}

/**
 * 编写类A01，定义方法max，实现求某个double数组的最大值，并返回
 */
class A01 {
    //求double数组最大值
    public Double max(double[] arr) {
        if (arr != null && arr.length > 0) {
            double max = arr[0];
            for (int i = 1; i < arr.length; i++) {
                if (max < arr[i]) {
                    max = arr[i];
                }
            }
            return max;
        }
        return null;
    }
}