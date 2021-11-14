package com.zhu.io_;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/11/2 17:31
 * @description:
 */
public class FileOutputStream_ {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\ZHUXIAOKANG\\Desktop\\hello2.txt";
        FileOutputStream fos=null;
        byte[] b={97,98,99};
        try {
            fos  = new FileOutputStream(filePath);
            fos.write(b);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
