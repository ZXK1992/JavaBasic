package com.zhu.array.homework;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/10/22 23:08
 * @description:
 */
public class Homework02 {
    public static void main(String[] args) {
        /**
         * 随机生成10个整数（1-100的范围）保存到数组，并倒序
         * 打印以及求平均值，求最大值和最大值的下标，并查找里面是否有8
         */
        for (int j = 0; j < 100; j++) {
            int[] arr = new int[10];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = (int) (Math.random() * 100 + 1);
            }
            System.out.println("=========正序打印============");
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " \t");
            }
            //倒序打印
            System.out.println("\n=========倒序打印============");
            for (int i = arr.length - 1; i >= 0; i--) {
                System.out.print(arr[i] + "\t");
            }
            //定义辅助变量
            int max = arr[0];
            int min = arr[0];
            int maxIndex = 0;
            int minIndex = 0;
            double sum = arr[0];
            for (int i = 1; i < arr.length; i++) {
                sum += arr[i];
                if (max < arr[i]) {
                    max = arr[i];
                    maxIndex = i;
                }
            }
            System.out.println("\n最大值=" + max + "最大值下标为=" + maxIndex);
            for (int i = 1; i < arr.length; i++) {
                if (min > arr[i]) {
                    min = arr[i];
                    minIndex = i;
                }
            }
            System.out.println("最小值=" + min + "最小值下标为=" + minIndex);
            //求平均值
            System.out.println("平均值=" + (sum / arr.length));
            int findNum = 8;
            int index = -1;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == 8) {
                    System.out.println("找到8，下标为" + i);
                    index = i;
                    break;
                }
            }
            if (index == -1) {
                System.out.println("数组里找不到8");
            }
        }
    }
}
