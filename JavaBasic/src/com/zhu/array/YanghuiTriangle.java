package com.zhu.array;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/9/30 17:46
 * @description:
 */
public class YanghuiTriangle {
    public static void main(String[] args) {
        //定义一个二维数组接收该三角数据、
        int level = 6;
        int [][] arrs = new int[level][];
        for (int i = 0; i < arrs.length; i++) {
          //给二维数组元素一维数组开空间，否则元素为空null
            arrs[i] = new int[i+1];
            for (int j = 0; j< arrs[i].length; j++) {
                if (j==0 || j==arrs[i].length-1){
                    arrs[i][j]=1;
                }else {
                    arrs[i][j] = arrs[i-1][j]+arrs[i-1][j-1];
                }
            }
        }

        for (int i = 0; i < arrs.length; i++) {
            for (int j = 0; j < arrs[i].length; j++) {
                System.out.print(arrs[i][j]+"\t");
            }
            System.out.println();
        }
    }
}
