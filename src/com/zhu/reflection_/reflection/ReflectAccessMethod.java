package com.zhu.reflection_.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author: ZHUXIAOKANG
 * @date: 2022/3/5 23:15
 * @description:
 */
public class ReflectAccessMethod {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        //1.得到Student类对应的Class对象
        Class<?> bossCls = Class.forName("com.zhu.reflection_.reflection.Boss");
        //2.创建对象
        Object o = bossCls.newInstance();
        //3.调用public的hi方法
        //Method hi = bossCls.getMethod("hi", String.class);
        //3.1得到hi方法对象
        Method hi = bossCls.getDeclaredMethod("hi", String.class);
        //3.2调用
        hi.invoke(o, "你好");

        //4.调用private static方法
        //4.1得到say方法对象
        Method say = bossCls.getDeclaredMethod("say", int.class, String.class, char.class);
        //4.2因为say方法是private，所以需要暴破，原理和前面讲的构造器和属性一样
        say.setAccessible(true);
        System.out.println(say.invoke(o,13,"朱锦",'男'));
        //4.3因为say方法是static的，还可以这样调用，可以传入null
        System.out.println(say.invoke(null, 18, "李四", '女'));

        //在反射中，如果方法有返回值，统一返回Object，但是他运行类型和方法定义的一样
        Object reVal = say.invoke(null, 300, "王五", '男');
        System.out.println("reVal的运行类型="+reVal.getClass());//String

        //在演示一个返回的案例
        Method m1 = bossCls.getDeclaredMethod("m1");
        Object reVal2 = m1.invoke(o);
        System.out.println("reVal2 的运行类型=" + reVal2.getClass());//Monster
    }
}
class Monster {}
class Boss {//类
    public int age;
    private static String name;
    public Boss() {//构造器
    }
    public Monster m1() {
        return new Monster();
    }
    private static String say(int n, String s, char c) {//静态方法
        return n + " " + s + " " + c;
    }
    public void hi(String s) {//普通 public 方法
        System.out.println("hi " + s);
    }

}