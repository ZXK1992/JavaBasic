package com.zhu.reflection_;

import java.io.*;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/11/19 17:27
 * @description:
 */@SuppressWarnings({"all"})
public class ReflectionTest01 {
    public static void main(String[] args) throws Exception {
        String filePath = "C:\\Users\\ZHUXIAOKANG\\IdeaProjects\\JavaBasic\\JavaBasic\\src\\com\\zhu\\reflection_\\re.properties";
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
        Properties properties = new Properties();
        properties.load(bufferedReader);
        String classfullpath = properties.getProperty("classfullpath");
        String method = properties.getProperty("method");
        Class aClass = Class.forName(classfullpath);

        Object o = aClass.newInstance();
        System.out.println(o.getClass());
        Method method1 = aClass.getMethod(method);
        method1.invoke(o);


    }
}
