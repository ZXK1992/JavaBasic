package com.zhu.io_.transformation;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * @author: ZHUXIAOKANG
 * @date: 2022/1/9 17:42
 * @description:
 * 编程将字节流FileOutputStream 包装成（转换成）字符流OutputStreamWriter，对
 *      文件进行写入（按照utf-8/gbk格式）
 */
public class OutputStreamWriter_ {
    public static void main(String[] args) throws IOException {
        String destpath = "D:\\MyCode\\JavaBasic\\src\\com\\zhu\\io_\\transformation\\b.txt";
        //1.创建流对象
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(destpath), "gbk");
        //2.写入
        osw.write("你好，Java吗？");
        //3.关闭
        osw.close();
        System.out.println("写入成功");

    }
}
