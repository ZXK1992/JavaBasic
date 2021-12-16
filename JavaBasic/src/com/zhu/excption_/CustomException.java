package com.zhu.excption_;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/11/22 20:25
 * @description:
 */
class AgeException extends RuntimeException{
    public AgeException(String message) {
        super(message);
    }
}
class CustomExceptionTest{
    public static void main(String[] args) /*throws AgeException*/ {
        int age = 180;
//要求范围在 18 – 120 之间，否则抛出一个自定义异常
        if(!(age >= 18 && age <= 120)) {
//这里我们可以通过构造器，设置信息
            throw new AgeException("年龄需要在 18~120 之间");
        }
        System.out.println("你的年龄范围正确.");
    }
}