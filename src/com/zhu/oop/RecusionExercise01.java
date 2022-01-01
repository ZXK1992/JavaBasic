package com.zhu.oop;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/10/1 10:50
 * @description:
 */
public class RecusionExercise01 {
    public static void main(String[] args) {
        A a = new A();
        int res = a.fibonacci(50);
        System.out.println(res);
    }
}

/**
 * 斐波拉切的递归解法
 */
class A{
    public int fibonacci(int n){
        if (n>=1 && n<=2){
            return 1;
        }
            return (fibonacci(n-1)+fibonacci(n-2));

    }
}