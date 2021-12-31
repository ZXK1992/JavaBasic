package com.zhu.common_class.big_;

import java.math.BigInteger;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/11/26 10:33
 * @description:
 */
public class BigInteger_ {
    /**
     * BigInteger应用场景
     * BigInteger适合保存比较大的整型
     */
    public static void main(String[] args) {
        //当我们编程中，需要处理很大的整数，long 不够用
//可以使用 BigInteger 的类来搞定
// long l = 23788888899999999999999999999l;
// System.md.out.println("l=" + l);
        BigInteger bigInteger = new BigInteger("23788888899999999999999999999");
        BigInteger bigInteger2 = new BigInteger("2378888811111111111899999999999999999999");
        System.out.println(bigInteger);
        System.out.println(bigInteger2);
        //1. 在对 BigInteger 进行加减乘除的时候，需要使用对应的方法，不能直接进行 + - * /
//2. 可以创建一个 要操作的 BigInteger 然后进行相应操作
        BigInteger add = bigInteger.add(bigInteger2);
        System.out.println(add);//
        BigInteger subtract = bigInteger.subtract(bigInteger2);
        System.out.println(subtract);//减
        BigInteger multiply = bigInteger.multiply(bigInteger2);
        System.out.println(multiply);//乘
        BigInteger divide = bigInteger.divide(bigInteger2);
        System.out.println(divide);//除
    }
}
