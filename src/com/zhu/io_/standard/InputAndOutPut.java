package com.zhu.io_.standard;

/**
 * @author: ZHUXIAOKANG
 * @date: 2022/1/9 16:43
 * @description:
 */
public class InputAndOutPut {
    public static void main(String[] args) {
      //  System.in 标准输入 编译类型 是InputStream，运行类型是BufferedInputStream
        //表示的是标准输入 默认键盘
        System.out.println(System.in.getClass());
        //System.out 编译类型，运行类型都是PrintStream
        //表示标准输出 默认显示器
        System.out.println(System.out.getClass());
    }
}
