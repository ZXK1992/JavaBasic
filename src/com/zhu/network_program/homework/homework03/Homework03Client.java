package com.zhu.network_program.homework.homework03;

import com.zhu.network_program.homework.homework03.utils.StreamUtils;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * @author: ZHUXIAOKANG
 * @date: 2022/1/20 15:07
 * @description: 客户端
 */
public class Homework03Client {
    /*
        1.编写客户端程序和服务端程序
       2.客户端可以输入一个音乐文件名,比如高山流水,服务端,收到音乐名后,可以给
       客户端返回这个音乐文件,如果服务器没有这个文件,返回一个默认的音乐即可
       3.客户端收到文件后,保存到本地D:\\
       4.提示:该程序可以使用StreamUtils.java
     */
    public static void main(String[] args) throws Exception {
        //客户端创建socket对象
        Socket socket = new Socket(InetAddress.getLocalHost(), 6666);
        System.out.println("请输入要下载的音乐名:");
        Scanner scanner = new Scanner(System.in);
        String next = scanner.next();
        //获取输出流
        OutputStream outputStream = socket.getOutputStream();
        //用字符流输出
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(outputStream));
        bw.write(next);
        bw.newLine();
        bw.flush();
        socket.shutdownOutput();
        //用socket创建读取服务端的音乐数据输入流
        InputStream inputStream = socket.getInputStream();
        byte[] bytes = StreamUtils.streamToByteArray(inputStream);
        //保存到D盘,输出流写入
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("D:\\" + next + ".mp3"));
        bos.write(bytes);
        bos.close();

        //关闭资源
        bw.close();
        socket.close();
    }
}
