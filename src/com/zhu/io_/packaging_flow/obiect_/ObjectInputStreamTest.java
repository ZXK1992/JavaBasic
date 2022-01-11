package com.zhu.io_.packaging_flow.obiect_;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * @author: ZHUXIAOKANG
 * @date: 2022/1/9 15:12
 * @description:
 * 使用ObjectInputStream读取data.dat 并反序列化恢复数据
 */
public class ObjectInputStreamTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String srcPath="D:\\MyCode\\JavaBasic\\src\\com\\zhu\\io_\\packaging_flow\\obiect_\\data.dat";
        //1.创建流对象
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(srcPath));
        //按序列化时写入的顺序读取
        System.out.println(ois.readInt());
        System.out.println(ois.readBoolean());
        System.out.println(ois.readChar());
        System.out.println(ois.readDouble());
        System.out.println(ois.readUTF());
        System.out.println(ois.readObject());
        //关流
        ois.close();

    }
}
