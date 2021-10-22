package com.zhu.variable.homework;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/10/16 17:18
 * @description:
 */
public class Homework04 {
    public static void main(String[] args) {
/*
        编程实现如下效果
        姓名    年龄   成绩   性别   爱好
        xx      xx     xx    xx     xx

        要求：
        1.用变量将姓名、年龄、成绩、性别、爱好存储
        2.使用+
        3.添加适当的注释
        4.添加转义字符，使用一条语句输出
*/
        //用变量将姓名、年龄、成绩、性别、爱好存储
        String name = "朱小康";
        int age = 29;
        double sorce = 100;
        char sex = '男';
        String hobby = "打篮球";
        //打印输出
        System.out.println("姓名\t年龄\t成绩\t性别\t爱好\n" + name
                + "\t" + age + "\t" + sorce + "\t" + sex
                + "\t" + hobby);

    }
}
