package com.zhu.io_.packaging_flow.char_;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author: ZHUXIAOKANG
 * @date: 2022/1/6 22:24
 * @description:
 */
public class BufferedReader_ {
    public static void main(String[] args) {
        /*
        使用如BufferedReader读取文本本间，并显示在控制台
         */
        BufferedReader bufferedReader = null;
        String filePath = "D:\\MyCode\\JavaBasic\\src\\com\\zhu\\io_\\read_write\\story.txt";
        try {
            FileReader fileReader = new FileReader(filePath);
            bufferedReader = new BufferedReader(fileReader);
            String str = null;//按行读取, 效率高
            //1. bufferedReader.readLine() 是按行读取文件
            //2. 当返回 null 时，表示文件读取完毕
            while ((str = bufferedReader.readLine()) != null) {
                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭流, 这里注意，只需要关闭 BufferedReader ，因为底层会自动的去关闭 节点流
            //FileReader。
            /*
            public void close() throws IOException {
                synchronized (lock) {
                if (in == null)
                    return;
                    try {
                     in.close();//in 就是我们传入的 new FileReader(filePath), 关闭了. } finally {
                     in = null;
                    cb = null;
                    }
                }
            }
*/
            //只需关闭外层流
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
