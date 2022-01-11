package com.zhu.io_.packaging_flow.obiect_;

import java.io.*;

/**
 * @author: ZHUXIAOKANG
 * @date: 2022/1/8 14:09
 * @description:  演示ObjectOutputStream的使用，完成数据的序列化
 */
public class ObjectOutputStreamTest {
    /*
    使用ObjectOutputStream序列化基本数据类型和一个Dog对象()
    保存到data.dat 文件中
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //序列化后，保存的文件格式，不是存文本，而是按照他的格式来保存
        String destPath="D:\\MyCode\\JavaBasic\\src\\com\\zhu\\io_\\packaging_flow\\obiect_\\data.dat";
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(destPath));
        //序列化数据到destpath
        oos.writeInt(100);;// int -> Integer (实现了 Serializable)
        oos.writeBoolean(true);// boolean -> Boolean (实现了 Serializable)
        oos.writeChar('a');// char -> Character (实现了 Serializable)
        oos.writeDouble(9.5);// double -> Double (实现了 Serializable)
        oos.writeUTF("韩顺平教育");//String
        //保存一个 dog 对象
        /*序列化对象时，默认将里面所有属性都进行序列化，但除了static或transient
                修饰的成员*/
        oos.writeObject(new Dog("小黄",3,"日本","白色"));
        //ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(destPath));
        //关闭流
        oos.close();

    }
}
