package com.zhu.io_.transformation;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author: ZHUXIAOKANG
 * @date: 2022/1/9 17:16
 * @description:
 * 由读取文件出现乱码引出转换流
 */
public class CodeQuestion {
    public static void main(String[] args) throws IOException {
        //读取 e:\\a.txt 文件到程序
//思路
//1. 创建字符输入流 BufferedReader [处理流]
//2. 使用 BufferedReader 对象读取 a.txt
//3. 默认情况下，读取文件是按照 utf-8 编码
        String filePath = "D:\\MyCode\\JavaBasic\\src\\com\\zhu\\io_\\transformation\\a.txt";
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        String s = br.readLine();
        System.out.println("读取到的内容: " + s);
        br.close();
//InputStreamReader
//OutputStreamWriter
    }
}
