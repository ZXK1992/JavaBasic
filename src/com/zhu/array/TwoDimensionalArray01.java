package com.zhu.array;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/9/29 9:43
 * @description:
 */
public class TwoDimensionalArray01{
    public static void main(String[] args) {
        //二维数组入门
        int [][] ints = {{0,0,0,0,0,0},{0,0,1,0,0,0},{0,2,0,3,0,0},{0,0,0,0,0,0}};
        for (int i = 0; i < ints.length; i++) {
            for (int i1 = 0; i1 < ints[i].length; i1++) {
                System.out.print(ints[i][i1]+" ");
            }
            System.out.println();
        }

    }
}
