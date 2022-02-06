package com.zhu.reflection_.class_;

import com.zhu.reflection_.Cat;

/**
 * @author: ZHUXIAOKANG
 * @date: 2022/2/3 22:03
 * @description: 对Class类特点的梳理
 */
public class Class01 {
    public static void main(String[] args) throws ClassNotFoundException {
        //看看Class类图
       //1. Class也是类,因此也继承Object类
        //2.Class类对象不是new出来的,而是系统创建的
        //(1)传统new对象
        //Cat cat = new Cat();
        /*
           public Class<?> loadClass(String name) throws ClassNotFoundException {
                return loadClass(name, false);
           }
         */
        //(2) 反射方式, 刚才老师没有 debug 到 ClassLoader 类的 loadClass, 原因是，我没有注销 Cat cat = newCat();

        /*
        ClassLoader 类, 仍然是通过 ClassLoader 类加载 Cat 类的 Class 对象
           public Class<?> loadClass(String name) throws ClassNotFoundException {
                return loadClass(name, false);
           }
         */
         Class cls1 = Class.forName("com.zhu.reflection_.Cat");

         //(3)对于某个类的Class类对象,在内存中只有一份,因此类只加载一次
        Class cls2 = Class.forName("com.zhu.reflection_.Cat");
        System.out.println(cls1.hashCode());
        System.out.println(cls2.hashCode());
        Class cls3 = Class.forName("com.zhu.reflection_.Dog");
        System.out.println(cls3.hashCode());




    }
}
