package com.zhu.operator.homework;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/10/16 17:15
 * @description:
 */
public class Homework01 {
    public static void main(String[] args) {
    //计算下列表达式
        System.out.println(10/3); // 3
        System.out.println(10/5); // 2
        System.out.println(10%2); // 0
        //a%b 当a是小数时，公式=a-（int）a/b*b;
        System.out.println(-10.5%3); // -1.5
        //注意： 有小数运算，得到结果是近似值

        int i = 66;
        System.out.println(++i+i); // 执行 i= i+1 =>i=67 => 134
    }
}
