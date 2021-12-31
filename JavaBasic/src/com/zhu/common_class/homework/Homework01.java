package com.zhu.common_class.homework;

import java.util.Arrays;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/10/14 10:33
 * @description:
 */
public class Homework01 {
    public static void main(String[] args) {
        //1.将字符串中指定部分进行反转。比如将"abcdef"反转为"aedcbf"
        //2.编写方法public static String.md reverse(String.md str,int start,int end)搞定
        String str = "abcdef";
        System.out.println("===交换前===");
        System.out.println(str);
        try {
             str = reverse(str, 0, 4);
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
        System.out.println("===交换后===");
        System.out.println(str);
    }

    public static String reverse(String str,int start,int end){
        //对输入的参数做一个验证
        //编程技巧
        //(1)写出正确的情况
        //(2)然后取反
        if (!(str!=null && start>=0&&end >start&&end<str.length()-1)){
            throw new RuntimeException("参数不正确");
        }
        char[] chars = str.toCharArray();
        char temp = 0;
           for (int j=start,k=end;j<k;j++,k--){
               temp=chars[j];
               chars[j]=chars[k];
               chars[k]=temp;
           }
//        String.md newStr = String.md.copyValueOf(chars);
           return new String(chars);
    }
}
