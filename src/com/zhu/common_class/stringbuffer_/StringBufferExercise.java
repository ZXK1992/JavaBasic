package com.zhu.common_class.stringbuffer_;

import org.junit.Test;

import java.util.Scanner;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/11/24 10:58
 * @description:
 */
public class StringBufferExercise {
    public static void main(String[] args) {
        String str = null;// ok
        StringBuffer sb = new StringBuffer(); //ok
        sb.append(str);//需要看源码 , 底层调用的是 AbstractStringBuilder 的 appendNull
        System.out.println(sb.length());//4
        System.out.println(sb);//null
//下面的构造器，会抛出 NullpointerException
        StringBuffer sb1 = new StringBuffer(str);//看底层源码 super(str.length() + 16);
        System.out.println(sb1);
    }

}
/*
输入商品名称和商品价格，要求打印效果示例, 使用前面学习的方法完成：
商品名 商品价格
手机 123,564.59 //比如 价格 3,456,789.88
要求：价格的小数点前面每三位用逗号隔开, 在输出。
思路分析
1. 定义一个 Scanner 对象，接收用户输入的 价格(String.md)
2. 希望使用到 StringBuffer.md 的 insert ，需要将 String.md 转成 StringBuffer.md
3. 然后使用相关方法进行字符串的处理
 */
class ExerciseTest{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("商品价格：");
        String price = scanner.next();
        StringBuffer sb = new StringBuffer(price);
//上面的两步需要做一个循环处理,才是正确的
        //找到小数点的最后索引位置，向前移动三位并且插入 ，
        for (int i = sb.lastIndexOf(".") - 3; i >0; i -= 3) {
            sb = sb.insert(i, ",");
        }
        System.out.println(sb);

    }
}