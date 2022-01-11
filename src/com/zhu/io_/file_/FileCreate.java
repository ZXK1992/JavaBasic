package com.zhu.io_.file_;

import java.io.File;
import java.io.IOException;

/**
 * @author: ZHUXIAOKANG
 * @date: 2022/1/4 22:20
 * @description:
 */
public class FileCreate {
    //请在e盘下，创建文件news1.txt.news2.txt,news.txt,用三种不同方式创建
    public static void main(String[] args) throws IOException {
        //方式1：根据路径构建一个file对象
        //这里的file1对象，在Java程序中，只是一个对象
        //只有执行了createNewFile方法，才会真正的，在磁盘创建该文件
        File file1 = new File("D:\\news1.txt");
        file1.createNewFile();
        //方式2 根据父目录文件+子路径构建
        File file2 = new File((File) null,"\\news2.txt");
        file2.createNewFile();
        //方式3 根据父目录+子路径构建
        File file3 = new File("D:\\","news.txt");
        file3.createNewFile();
    }
}
