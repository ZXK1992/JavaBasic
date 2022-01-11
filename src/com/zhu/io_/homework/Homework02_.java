package com.zhu.io_.homework;

import java.io.*;

/**
 * @author: ZHUXIAOKANG
 * @date: 2022/1/9 11:11
 * @description:
 */
public class Homework02_ {
    /**
     * 要求使用BufferedReader读取一个文本文件，为每行加上行号，再
     * 连同内容一并输出到屏幕
     * 如果把文件编码改成gbk,出现中文乱码，解决方式用转换流
     * @param args
     */
    public static void main(String[] args) {
        String srcpath="D:\\MyCode\\JavaBasic\\src\\com\\zhu\\io_\\homework\\note1.txt";
        InputStreamReader isr=null;
        try {
            //创建转换流
            isr=new InputStreamReader(new FileInputStream(srcpath),"gbk");
            BufferedReader  br=new BufferedReader(isr);
            String line=null;
            int num=1;
            while ((line=br.readLine())!=null){
                System.out.println("第"+(num++)+"行 "+line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (isr!=null){
                    isr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("读取完毕");


    }
}
