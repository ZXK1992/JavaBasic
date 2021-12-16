package com.zhu.common_class.string_;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/10/12 17:29
 * @description:
 */
public class String_ {
    public static void main(String[] args) {
        String a = "aa";
        String b = "bb";
        final char[] value = {'a', 'b', 'c'};
        char[] v2 = {'t', 'o', 'm'};
        value[0] = 'H';
//value = v2; 不可以修改 value 地址
//        //
//        String c =new String("aa");
//        System.out.println(c.intern()==a);
        //      String d="aa"+"bb";
       /* 底层是StringBuilder sb =new StringBuilder();sb.append(a);
        sb.append(b);,sb是在堆中，并且append是在原来字符串的基础上追加的
        重要规则,String d="aa"+"bb";常量相加，看的是池。 String e=a+b;
        变量相加，是在堆中*/
        String e = a + b;
        char[] chars = {'a', 'b', 'c'};
        String s = new String(chars, 1, 2);
        System.out.println(s);

    }
}
