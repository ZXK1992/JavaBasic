package com.zhu.io_.homework;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author: ZHUXIAOKANG
 * @date: 2022/1/9 11:11
 * @description:
 */
public class Homework02 {
    /**
     * 要求使用BufferedReader读取一个文本文件，为每行加上行号，再
     * 连同内容一并输出到屏幕
     * @param args
     */
    public static void main(String[] args) {
        String srcpath="D:\\MyCode\\JavaBasic\\src\\com\\zhu\\io_\\homework\\note.txt";
        BufferedReader br=null;
        try {
            br=new BufferedReader(new FileReader(srcpath));
            String line=null;
            int num=1;
            while ((line=br.readLine())!=null){
                System.out.println("第"+(num++)+"行 "+line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br!=null){
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("读取完毕");


    }
}
