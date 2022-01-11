package com.zhu.io_.homework;

import java.io.*;

/**
 * @author: ZHUXIAOKANG
 * @date: 2022/1/5 16:39
 * @description:
 */
public class Homework01 {
    /*
    1)判断D盘下是否有文件夹mytemp,如果没有就创建mytemp
    2）在D:\\mytemp目录下创建文件hello.txt
    3)如果hello.txt已经存在，提示该文件已经存在，就不要再重复创建
    4）并且在hello.txt 文件中写入hello,world~
     */
    public static void main(String[] args) throws IOException {
        String directoryPath = "D:\\mytemp";
        File file = new File(directoryPath);
        //如果文件夹(目录)不存在创建
        if (!file.exists()) {
            //创建成功
            if (file.mkdirs()) {
                System.out.println("目录" + file + "创建成功");
            } else {
                System.out.println("目录" + file + "创建失败");
            }
        }
        //上面if执行完，说明目录肯定存在了

        String filePath = directoryPath + "\\hello.txt";
        File file2 = new File(filePath);
        //如果文件不存在，就创建
        if (!file2.exists()) {
            if (file2.createNewFile()) {
                System.out.println("文件" + filePath + "创建成功");
                //如果文件创建成功就使用BufferedWriter输出流写入
                BufferedWriter bw = new BufferedWriter(new FileWriter(filePath));
                bw.write("hello,world~");
                System.out.println("写入完毕");
                bw.close();
            } else {
                System.out.println("文件" + filePath + "创建失败");
            }
        } else {
            //如果文件已经存在，给出提示信息
            System.out.println("文件" + filePath + "已存在，不再重复创建");
        }
    }
}
