package com.zhu.io_.filecopy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/11/3 11:15
 * @description:
 */
public class FileCopy {
    public static void main(String[] args) {
        String srcFilePath="C:\\Users\\ZHUXIAOKANG\\Desktop\\位运算练习.png";
        String destFilePath="C:\\Users\\ZHUXIAOKANG\\IdeaProjects\\JavaBasic" +
                "\\JavaBasic\\src\\com\\zhu\\io_\\位运算练习.png";
        FileInputStream fis = null;
        FileOutputStream fos =null;
        byte[] bytes = new byte[1024];
        int readData=0;
        try {
            fis = new FileInputStream(srcFilePath);
            fos = new FileOutputStream(destFilePath);
            while ((readData=fis.read(bytes))!=-1){
                fos.write(bytes,0, readData);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fis!=null){
                    fis.close();
                }
                if (fos!=null){
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("复制完成");
    }
}
