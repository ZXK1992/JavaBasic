package com.zhu.io_.printstream;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author: ZHUXIAOKANG
 * @date: 2022/1/9 18:25
 * @description:
 */



public class PrintWriter_ {
    public static void main(String[] args) throws IOException {
        //默认控制台
        //PrintWriter printWriter = new PrintWriter(System.out);
        PrintWriter printWriter = new PrintWriter(new FileWriter("D:\\MyCode\\JavaBasic\\src\\com\\zhu\\io_\\printstream\\f2.txt"));
        printWriter.print("你好zz");
        printWriter.close();;//flush + 关闭流, 才会将数据写入到文件..
    }
}
