package com.zhu.io_;

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
     * 请使用 FileInputStream 读取 hello.txt 文件.md，并将文件内容显示到控制台
     *使用read()
     * @param args
     */
    public static void main(String[] args) {
        String filePath = "C:\\Users\\ZHUXIAOKANG\\Desktop\\hello.txt";
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(filePath);
            int readData = 0;
            while ((readData = fis.read()) != -1) {
                System.out.print((char) readData);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 使用read(byte[])
     */
    @Test
    public void m2(){
        String filePath = "C:\\Users\\ZHUXIAOKANG\\Desktop\\hello.txt";
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(filePath);
            byte[] bytes = new byte[8];
            int readData = 0;
            while ((readData = fis.read(bytes)) != -1) {
                String s = new String(bytes);
                System.out.print(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
