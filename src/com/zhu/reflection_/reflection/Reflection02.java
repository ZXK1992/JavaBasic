package com.zhu.reflection_.reflection;

import com.zhu.reflection_.Cat;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

import static com.zhu.oop3.interface_.IA.m2;


/**
 * @author: ZHUXIAOKANG
 * @date: 2022/2/2 21:06
 * @description: 测试反射调用的调优,执行9000000次
 */
public class Reflection02 {
    public static void main(String[] args) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException, NoSuchFieldException {
        m1();
        m2();
        m3();

    }


    //传统的技术new对象调用方法耗时
    private static void m1() {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 9000000; i++) {
            Cat cat = new Cat();
            cat.hi();
        }
        long end = System.currentTimeMillis();
        System.out.println("传统的技术new对象调用方法耗时" + (end - start));

    }

    //反射技术创建对象执行对象方法耗时
    private static void m2() throws ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 9000000; i++) {
            Class cls = Class.forName("com.zhu.reflection_.Cat");
            Cat o = (Cat) cls.newInstance();
            Method hi = cls.getMethod("hi");
            hi.invoke(o);
        }
        long end = System.currentTimeMillis();
        System.out.println("反射技术创建对象执行对象方法耗时" + (end - start));

    }

    //反射调优创建对象执行对象方法耗时耗时
    //反射调用优化 + 关闭访问检查
    private static void m3() throws IllegalAccessException, InstantiationException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 9000000; i++) {
            Class cls = Class.forName("com.zhu.reflection_.Cat");
            Cat o = (Cat) cls.newInstance();
            Method hi = cls.getMethod("hi");
            hi.setAccessible(true);;//在反射调用方法时，取消访问检查
            hi.invoke(o);

        }
        long end = System.currentTimeMillis();
        System.out.println("反射调优创建对象执行对象方法耗时耗时" + (end - start));
    }

}
