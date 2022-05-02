package com.zhu.common_class.string_;

/**
 * @author: ZHUXIAOKANG
 * @date: 2022/5/26 20:01
 * @description:
 */
public class StringExcise {
/*
写一个方法，要求把字符串“abcd+efghi”输出为“ihgf+edcba”。字符倒序输出，但是符号保持原位置。
 */
    public static void main(String[] args) {
        String str = "abcd+efghi";
        String newStr = outPutString(str);
        System.out.println(newStr);

        System.out.println(String.valueOf(true) == "true");

        //int a[][]=new int[][2];
         int a1[][]={{1,2},{2,2,6},{2,3}};
        String s[][]=new String[2][];
        String s1[][]={{"ace","d"},{"","dd"}};
        byte b1=1,b2=2,b3,b6;
        final byte b4=4,b5=6;
        b6 = b4+b5;
        //b3 = (b1+b2);
       // System.out.println(b3+b6);


    }

    public static String outPutString(String str){
        String newStr;
        String[] split = str.split("\\+");
        StringBuffer stringBuffer = new StringBuffer(split[0]);
        StringBuffer reverse1 = stringBuffer.reverse();

        stringBuffer=new StringBuffer(split[1].substring(1));
        StringBuffer reverse2 = stringBuffer.reverse();
        newStr=reverse2.append("+").append(split[1].charAt(0)).append(reverse1).toString();
        return newStr;

    }
}
