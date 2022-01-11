package com.zhu.io_.read_write;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @author: ZHUXIAOKANG
 * @date: 2022/1/6 14:10
 * @description:
 */
public class FileWriter_ {
    public static void main(String[] args) {
        /*
        使用FileWriter 将“风雨之后，定见彩虹”，写入到note.txt
         */
        String path = "D:\\MyCode\\JavaBasic\\src\\com\\zhu\\io_\\read_write\\note.txt";
        FileWriter fileWriter=null;
        try {
            //此方法是覆盖上次写入的
            fileWriter=new FileWriter(path);
            //此方法是追加到上次写入的后面
            //fileWriter=new FileWriter(path,true);
            fileWriter.write("风雨之后，定见彩虹");
            //写入字符串的指定部分
            fileWriter.write("你好啊",0,2);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //如果不关闭流，内容是写不到文件的
                //对应 FileWriter , 一定要关闭流，或者 flush 才能真正的把数据写入到文件
                fileWriter.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("程序结束");
    }
}
