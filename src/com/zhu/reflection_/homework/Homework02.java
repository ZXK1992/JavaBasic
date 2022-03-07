package com.zhu.reflection_.homework;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author: ZHUXIAOKANG
 * @date: 2022/3/6 21:39
 * @description:
 */
public class Homework02 {
    /*
        1.利用Class类的forName方法得到File类的class对象
        2.在控制台打印File类的所有构造器
        3.通过newInstance的方法创建File对象，并创建D:\mynew.txt文件

     */
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //1.利用Class类的forName方法得到File类的class对象
        Class<?> fileCls = Class.forName("java.io.File");
        //2.在控制台打印File类的所有构造器
        Constructor<?>[] declaredConstructors = fileCls.getDeclaredConstructors();
        System.out.println("File类的所有构造器如下：");
        //遍历输出
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            System.out.println(declaredConstructor);
        }
        //3. 指定的得到 public java.io.File(java.lang.String)
        Constructor<?> strConstructor = fileCls.getDeclaredConstructor(String.class);
        //创建file对象
        Object o = strConstructor.newInstance("D:\\mynew.txt");
        //4. 得到createNewFile 的方法对象
        Method createNewFile = fileCls.getDeclaredMethod("createNewFile");
        createNewFile.invoke(o);//创建文件，调用的是 createNewFile

    }
}
