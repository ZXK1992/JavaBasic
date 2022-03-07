package com.zhu.reflection_.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author: ZHUXIAOKANG
 * @date: 2022/3/5 21:41
 * @description: 演示通过反射机制创建实例
 */
public class ReflectCreateInstance {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
       //1. 先获取User类的Class对象
        Class<?> userClass = Class.forName("com.zhu.reflection_.reflection.User");
        //2.通过public的无参构造器创建实例
        Object o = userClass.newInstance();
        System.out.println(o);
        //3.通过public的有参构造器创建实例
        /*
        constructor 对象就是
        public User(String name) {//public 的有参构造器
            this.name = name;
        }
         */
        //3.1先得到对应构造器
        Constructor<?> constructor = userClass.getConstructor(String.class);
        //3.2创建实例，并传入实参
        Object zxk = constructor.newInstance("zxk");
        System.out.println("zxk=" + zxk);
        //4.通过非public的有参构造器创建实例
        //4.1得到private的构造器对象
        Constructor<?> constructor1 = userClass.getDeclaredConstructor(int.class, String.class);
        //4.2创建实例
        //暴破【暴力破解】 , 使用反射可以访问 private 构造器/方法/属性, 反射面前，都是纸老虎
        constructor1.setAccessible(true);
        Object user2 = constructor1.newInstance(100, "张三丰");
        System.out.println("user2=" + user2);

    }
}
class User { //User 类
    private int age = 10;
    private String name = "韩顺平教育";
    public User() {//无参 public
    }
    public User(String name) {//public 的有参构造器
        this.name = name;
    }
    private User(int age, String name) {//private 有参构造器
        this.age = age;
        this.name = name;
    }
    public String toString() {
        return "User [age=" + age + ", name=" + name + "]";
    }
}