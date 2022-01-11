package com.zhu.io_.packaging_flow.char_;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author: ZHUXIAOKANG
 * @date: 2022/1/6 22:32
 * @description:
 */
public class BufferedWriter_ {
    public static void main(String[] args) {
        /*
        使用BufferedWriter将“hello，韩顺平教育”,写入到文件1.txt
         */
        BufferedWriter bufferedWriter = null;
        try {
            //说明:
            //1. new FileWriter(filePath, true) 表示以追加的方式写入
            //2. new FileWriter(filePath) , 表示以覆盖的方式写入
            FileWriter fileWriter = new FileWriter("D:\\MyCode\\JavaBasic\\src\\com\\zhu\\io_\\read_write\\1.txt");
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("hello，韩顺平教育");
            //换行
            bufferedWriter.newLine();//插入一个和系统相关的换行
            bufferedWriter.write("心相印");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //说明：关闭外层流即可 ， 传入的 new FileWriter(filePath) ,会在底层关闭
                if (bufferedWriter != null) {
                    bufferedWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("程序执行完");

    }
}
