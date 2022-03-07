package com.zhu.reflection_.homework;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author: ZHUXIAOKANG
 * @date: 2022/3/6 11:10
 * @description:
 */
public class Homework01 {
    /*
        练习1：通过反射修改私有成员变量
        1.定义PrivateTest类，有私有name属性，并且属性值为helloKitty
        2.提供getName的公有方法
        3.创建PrivateTest的类，利用Class类得到私有的name属性，修改私有的name属性值，并调用getName()
        的方法打印name属性值

     */
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        //1.得到PrivateTest类的类对象
        Class<?> privateTestCls = Class.forName("com.zhu.reflection_.homework.PrivateTest");
        //2.创建实例
        Object o = privateTestCls.newInstance();
        //3.得到PrivateTest类的私有属性name
        Field name = privateTestCls.getDeclaredField("name");
        //4.使用属性修改前需要进行暴破才能访问
        name.setAccessible(true);
        //修改name属性值
        name.set(o,"zhuxiaokang");
        //5.得到getName方法对象
        Method getName = privateTestCls.getDeclaredMethod("getName");
        System.out.println(getName.invoke(o));
    }
}

class PrivateTest{
    private String name="helloKitty";

    public String getName() {
        return name;
    }
}