package com.zhu.io_.inputstream_;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/11/1 17:21
 * @description:
 */
public class FileInputStream_ {
    /**
     * 请使用 FileInputStream 读取 hello.txt 文件，并将文件内容显示到控制台
     *使用read()
     * @param args
     */
    public static void main(String[] args) {
        String filePath = "C:\\Users\\ZHUXIAOKANG\\Desktop\\hello.txt";
        FileInputStream fis = null;
        try {
            //创建 FileInputStream 对象，用于读取 文件
            fis = new FileInputStream(filePath);
            int readData = 0;
            //单个字节读取
            //从该输入流读取一个字节的数据。 如果没有输入可用，此方法将阻止。
            //如果返回-1 , 表示读取完毕
            while ((readData = fis.read()) != -1) {
                System.out.print((char) readData);//转成 char 显示
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //关闭文件流，释放资源.
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 使用 read(byte[] b) 读取文件，提高效率
     */
    @Test
    public void m2(){
        String filePath = "C:\\Users\\ZHUXIAOKANG\\Desktop\\hello.txt";
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(filePath);
            //字节数组
            byte[] bytes = new byte[8];//一次读取 8 个字节.
            int readData = 0;
            //从该输入流读取最多 b.length 字节的数据到字节数组。 此方法将阻塞，直到某些输入可用。
            //如果返回-1 , 表示读取完毕
            //如果读取正常, 返回实际读取的字节数
            while ((readData = fis.read(bytes)) != -1) {
                String s = new String(bytes,0,readData);
                System.out.print(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //关闭文件流，释放资源
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
