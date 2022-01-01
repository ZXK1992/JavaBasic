package com.zhu.excption_;

import org.junit.Test;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/11/21 10:34
 * @description:
 */
public class ExceptionTest {

    @Test
    public void nullPointExceptionTest() {
        String name = null;
        //用null的对象去调用方法，属性
        System.out.println(name.getBytes());
    }

    @Test
    public void arrayIndexOutOfBoundsExceptionTest() {
        int[] arrs = {1, 2, 3};
        //数组的下标1-2，这里访问了arrs[3]
        for (int i = 0; i <= arrs.length; i++) {
            System.out.println(arrs[i]);
        }
    }

    @Test
    public void arithmeticExceptionTest() {
        //除以0
        System.out.println(1 / 0);
    }

    /*
     ClassCastException 类型转换异常
     当试图将对象强制转换为不是实例的子类时，
     抛出该异常。
     */
    @Test
    public void classCastExceptionTest() {
        ExceptionTest a = new AA();//向上转型
        AA a1 = (AA) a;//向下转型
        BB b = (BB) a;//试图将对象a强制转换为不是实例的子类

    }

    /**
     * 当应用程序试图将字符串转换成一种数值类型，
     * 但该字符串不能转换为适当格式时，抛出该异常
     */
    @Test
    public void numberFormatExceptionTest() {
        System.out.println(Integer.parseInt("aa"));

    }
}

class AA extends ExceptionTest {
}

class BB extends ExceptionTest {
}