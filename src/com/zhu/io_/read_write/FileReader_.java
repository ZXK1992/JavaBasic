package com.zhu.io_.read_write;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author: ZHUXIAOKANG
 * @date: 2022/1/6 14:00
 * @description:
 */
public class FileReader_ {
    public static void main(String[] args) {
        /*
        使用FileRead 从story.txt 读取内容，并显示
         */
        String path="D:\\MyCode\\JavaBasic\\src\\com\\zhu\\io_\\read_write\\story.txt";
        FileReader fileReader=null;
        try {
            fileReader=new FileReader(path);
            //每次读取这么多个字符数组
            char [] buff = new char[10];
            //每次读取的长度
            int readLen=0;
            //循环读取 使用 read(buf), 返回的是实际读取到的字符数
            //如果返回-1, 说明到文件结束
            while ((readLen=fileReader.read(buff))!=-1){
                System.out.print(new String(buff,0,readLen));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
