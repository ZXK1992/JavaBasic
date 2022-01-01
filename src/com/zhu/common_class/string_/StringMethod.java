package com.zhu.common_class.string_;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/11/23 21:06
 * @description:
 */
public class StringMethod {
    public static void main(String[] args) {
        // 4.indexOf 获取字符在字符串对象中第一次出现的索引，索引从 0 开始，如果找不到，返回-1
        String s1 = "wer@terwe@g";
        int index = s1.indexOf('@');
        System.out.println(index);// 3
        System.out.println("weIndex=" + s1.indexOf("we"));//0
// 5.lastIndexOf 获取字符在字符串中最后一次出现的索引，索引从 0 开始，如果找不到，返回-1
        s1 = "wer@terwe@g@";
        index = s1.lastIndexOf('@');
        System.out.println(index);//11
        System.out.println("ter 的位置=" + s1.lastIndexOf("ter"));//4
// 6.substring 截取指定范围的子串
        String name = "hello,张三";
//下面 name.substring(6) 从索引 6 开始截取后面所有的内容
        System.out.println(name.substring(6));//截取后面的字符
        //name.substring(0,5)表示从索引 0 开始截取，截取到索引 5-1=4 位置
        System.out.println(name.substring(0,5));
        System.out.println(name.substring(2,5));//llo
// 7.compareTo 比较两个字符串的大小，如果前者大，
// 则返回正数，后者大，则返回负数，如果相等，返回 0
// 老韩解读
// (1) 如果长度相同，并且每个字符也相同，就返回 0
// (2) 如果长度相同或者不相同，但是在进行比较时，可以区分大小
// 就返回 if (c1 != c2) {
// return c1 - c2;
// }
// (3) 如果前面的部分都相同，就返回 str1.len - str2.len
        String a = "jcck";// len = 3
        String b = "jack";// len = 4
        System.out.println(a.compareTo(b)); // 返回值是 'c' - 'a' = 2 的值
// 8.format 格式字符串
        /* 占位符有:
         * %s 字符串 %c 字符 %d 整型 %.2f 浮点型
         *
         */
        String name1 = "john";
        int age = 10;
        double score = 56.857;
        char gender = '男';

//将所有的信息都拼接在一个字符串.
String info =
        "我的姓名是" + name1 + "年龄是" + age + ",成绩是" + score + "性别是" + gender + "。希望大家喜欢我！ ";
        System.out.println(info);
        //用占位符表示上面的属性
        String formatStr = "我的姓名是%s 年龄是%d，成绩是%.2f 性别是%c.希望大家喜欢我！";
        String info2 = String.format(formatStr, name, age, score, gender);
        System.out.println("info2=" + info2);
    }
}
