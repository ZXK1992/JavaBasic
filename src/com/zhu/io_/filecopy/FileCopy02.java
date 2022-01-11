package com.zhu.io_.filecopy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author: ZHUXIAOKANG
 * @date: 2022/1/5 22:42
 * @description:
 */
public class FileCopy02 {
    public static void main(String[] args) {
        //复制文件
        /*
        思路分析：
            1.创建文件的输入流，将文件读入到程序
            2.创建文件的输出流，将读取到的文件数据，写入到指定文件
         */
        String srcPath="D:\\BaiduNetdiskDownload\\韩顺平 2021零基础学Java 【软件 资料 代码 笔记】\\资料\\分享资料\\分享资料\\111.wav";
        String posPath="D:\\MyCode\\JavaBasic\\src\\com\\zhu\\io_\\tankgame.wav";
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream(srcPath);
            fos = new FileOutputStream(posPath);
            //定义一个字节数组,提高读取效果
            byte [] buff=new byte[1024];
            int readLen = 0;
            while ((readLen=fis.read(buff))!=-1){
                //边读边写为复制
                //读取到后，就写入到文件 通过 fileOutputStream
                //即，是一边读，一边写
                //如果用fos.write(buff)可能会出现文件损失，会出问题
                fos.write(buff,0,readLen);//一定要使用这个方法

            }
            System.out.println("复制完毕");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fis.close();
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
