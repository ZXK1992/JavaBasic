package com.zhu.io_.inputstream_;

import java.beans.Encoder;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * @author: ZHUXIAOKANG
 * @date: 2022/1/5 20:29
 * @description:
 */
public class FileInputStream02 {
    public static void main(String[] args) {
        String path = "C:\\Users\\ZHUXIAOKANG\\Desktop\\new 1.txt";
        FileReader fis = null;
        try {
            fis = new FileReader(path);
            BufferedReader bufferedReader = new BufferedReader(fis);
            String  str=null;
            char [] b = new char[1024];
            while ( (str=bufferedReader.readLine())!=null){
                System.out.println(new String(str));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
