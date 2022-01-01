package com.zhu.common_class.homework;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/11/27 17:44
 * @description:
 */
public class Homework05 {
    /*
    已知Animal类有属性name，可以通过有参构造为属性赋值
     */
    public static void main(String[] args) {
        String s1="hspedu";
        Animal a = new Animal(s1);
        Animal b = new Animal(s1);
        System.out.println(a==b);//f
        System.out.println(a.equals(b));//f
        System.out.println(a.name==b.name);//t
        String s4=new String("hspedu");
        String s5="hspedu";
        System.out.println(s1==s4);//f
        System.out.println(s4==s5);//f
        String t1="hello"+s1;
        String t2="hellohspedu";
        System.out.println(t1.intern()==t2);//t
    }
}
class Animal{
    String name;

    public Animal(String name) {
        this.name = name;
    }
}