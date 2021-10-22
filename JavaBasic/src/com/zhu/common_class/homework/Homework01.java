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
        //2.编写方法public static String reverse(String str,int start,int end)搞定
        System.out.println(reverse("abcdef",1,4));;
    }

    public static String reverse(String str,int start,int end){
        char[] chars = str.toCharArray();
        String str1="";
        for (int i = 0; i < chars.length; i++) {
            if (i>=start && i<=end){
                str1+=chars[i];
            }
        }
        char[] chars1 = str1.toCharArray();
        char[] chars2 = new char[chars1.length];
        for (int i = chars1.length-1; i >=0; i--) {
            chars2[chars1.length-i-1]=chars1[i];
        }
        String str2="";
        for (int i = 0; i < chars2.length; i++) {
            str2+=chars2[i];
        }
       String reverse = str.charAt(0)+str2+str.charAt(str.length()-1);
        return reverse ;
    }
}
