package com.zhu.io_.homework;

import com.zhu.io_.read_write.FileWriter_;

import java.io.*;
import java.util.Properties;

/**
 * @author: ZHUXIAOKANG
 * @date: 2022/1/9 11:53
 * @description:
 */
public class Homework03 {
    /*
    1)要编写一个dog.properties
    name=tom
    age=5
    color=red
    2)编写Dog类Dog(String name, int age, String color) ，创建一个dog对象，读取
    dog.properties用相应的内容完成属性初始化，并输出
    3)将创建的Dog对象，序列化到文件dog.dat文件
     */
    public static void main(String[] args) {
        //创建Properties
        Properties properties = new Properties();
        String path = "D:\\MyCode\\JavaBasic\\src\\com\\zhu\\io_\\homework\\dog.properties";
        //加载
        try {
            properties.load(new FileReader(path));
            //创建dog对象
            Dog dog = new Dog(properties.getProperty("name"),
                    Integer.parseInt(properties.getProperty("age")),properties.getProperty("color"));
            System.out.println(dog);
            //序列化
            String destpath = "D:\\MyCode\\JavaBasic\\src\\com\\zhu\\io_\\homework\\dog.dat";
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(destpath));
            oos.writeObject(dog);
            oos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
