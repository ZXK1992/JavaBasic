package com.zhu.io_.file_;

import java.io.File;

/**
 * @author: ZHUXIAOKANG
 * @date: 2022/1/5 14:45
 * @description:
 */
public class FileInformation {
    /*
    如何获取到文件的大小、文件名、路径、父File，是文件还是目录
    (目录本质也是文件，一种特殊的文件)，是否存在
     */
    public static void main(String[] args) {
        File file = new File("D:\\news1.txt");
//        getName获取文件名字
        System.out.println("文件名="+file.getName());
//                getAbsolutePath绝对路径
        System.out.println("文件绝对路径="+file.getAbsolutePath());
//        getParent父目录
        System.out.println("文件父目录="+file.getParent());
//        length大小(文件有多少字节）
        System.out.println("文件大小="+file.length());
//                exists（是否存在）
        System.out.println("文件是否存在="+file.exists());
//                isFile是不是文件
        System.out.println("是不是文件="+file.isFile());//T
//                isDirectory是不是目录
        System.out.println("是不是目录="+file.isDirectory());
    }
}
