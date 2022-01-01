package com.zhu.excption_;

import java.io.FileInputStream;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/10/11 22:06
 * @description:
 */
public class ThrowsDetail {
    public static void main(String[] args) {

    }

    public void  f1(){
        //1.对于编译异常,程序中必须处理,编译不通过
        //FileInputStream fileInputStream = new FileInputStream("D:\\aa.txt");
        //2.对于与运行时异常,不处理会默认抛给jvm处理
        //int i = 10/0;
            //3.子类重写父类方法时，对抛出异常的规定：子类重写的方法，
        //所抛出的异常类型要么是和父类抛出的异常一致，要么为父类抛出的异常类型的子类
       // 4在throws过程中，如果有方法try-catch，就相当于处理异常，就可以不必throws
    }
    public static void f2(){

    }

}
