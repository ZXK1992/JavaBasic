package com.zhu.reflection_.reflection;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @author: ZHUXIAOKANG
 * @date: 2022/2/2 21:06
 * @description:
 */
public class Reflection01 {
    public static void main(String[] args) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException, NoSuchFieldException {
        //1.使用Properties类,可以读写配置
        Properties properties = new Properties();
        properties.load(new FileInputStream("src/com/zhu/reflection_/re.properties"));
        String classfullpath = properties.get("classfullpath").toString();//"com.zhu.reflection_.Cat"
        String methodName = properties.get("method").toString();//"hi"
        //2.使用反射机制解决问题
        //(1)加载类,返回Class类型的对象cls
        Class cls = Class.forName(classfullpath);
        //(2)通过cls得到你加载的类的对象实例
        Object o = cls.newInstance();
        System.out.println("o的运行类型"+o.getClass());
        //(3)通过cls得到你加载的类的methodName的方法对象
        //即: 在反射中,可以把方法视为对象(万物皆对象)
        Method method1 = cls.getMethod(methodName);
        //(4)通过method1调用方法:即通过方法对象来实现调用方法
        method1.invoke(o);//传统方法,对象.方法(),反射机制,方法.invoke(对象)

        //   Java.lang.reflect.Field代表类的成员变量,Field对象表示某个类的成员变量
        //得到name字段
        //getField不能得到私有的属性
        //cls.getField("name");
        Field ageField = cls.getField("age");
        System.out.println(ageField.get(o));//传统写法,对象.成员变量, 反射:成员变量对象.get(对象);
        //java.lang.reflect.Constructor: 代表类的构造方法, Constructor 对象表示构造器
        Constructor constructor = cls.getConstructor();//()中可以指定构造器参数类型,返回无参构造器
        System.out.println(constructor); //Cat();
        Constructor constructor1 = cls.getConstructor(String.class);//这里老师传入的 String.class 就是 String 类的Class 对象
        System.out.println(constructor1);//;//Cat(String name)


    }
}
