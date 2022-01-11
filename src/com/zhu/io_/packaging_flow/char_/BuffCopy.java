package com.zhu.io_.packaging_flow.char_;

import java.io.*;

/**
 * @author: ZHUXIAOKANG
 * @date: 2022/1/7 22:08
 * @description:
 */
public class BuffCopy {
    /*
    综合使用 BufferedReader  BufferedWriter完成文件拷贝，注意文件编码
     */
    public static void main(String[] args) throws IOException {
        //说明
        //1. BufferedReader 和 BufferedWriter 是安装字符操作
        //2. 不要去操作 二进制文件[声音，视频，doc, pdf ], 可能造成文件损坏
        String srcPath="D:\\MyCode\\JavaBasic\\src\\com\\zhu\\io_\\read_write\\story.txt";
        String desPath="D:\\MyCode\\JavaBasic\\src\\com\\zhu\\io_\\read_write\\storycopy.txt";
        BufferedReader bufferedReader=null;
        BufferedWriter bufferedWriter=null;
        try {
             bufferedReader = new BufferedReader(new FileReader(srcPath));
             bufferedWriter = new BufferedWriter(new FileWriter(srcPath));
             String line;
            //说明: readLine 读取一行内容，但是没有换行
             while ((line=bufferedReader.readLine())!=null){
                 //每读取一行，就写入
                 bufferedWriter.write(line);
                 //注意要换行
                 //插入一个换行
                 bufferedWriter.newLine();
             }
            System.out.println("复制完毕");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //判断包装流不为空才关闭
                if (bufferedReader!=null){
                    bufferedReader.close();
                }
                if (bufferedWriter!=null){
                    bufferedWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
