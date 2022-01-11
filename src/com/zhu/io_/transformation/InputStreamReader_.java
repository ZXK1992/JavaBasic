package com.zhu.io_.transformation;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author: ZHUXIAOKANG
 * @date: 2022/1/9 17:32
 * @description:
 * 1.编程将字节流FileInputStream 包装成（转换成）字符流InputStreamReader，对
 *      文件进行读取（按照utf-8/gbk格式），进而在包装成BufferedReader
 */
public class InputStreamReader_ {
    public static void main(String[] args) throws IOException {
        String srcpath ="D:\\MyCode\\JavaBasic\\src\\com\\zhu\\io_\\transformation\\a.txt";
        //1. 把 FileInputStream 转成 InputStreamReader
        //2.指定编码gbk
        InputStreamReader isr = new InputStreamReader(new FileInputStream(srcpath), "gbk");
        //3.把InputStreamReader传入BufferedReader
        BufferedReader br = new BufferedReader(isr);
        String line;
        //3.读取
        while ((line=br.readLine())!=null){
            System.out.println(line);
        }
        //关闭外层流
        br.close();


    }
}
