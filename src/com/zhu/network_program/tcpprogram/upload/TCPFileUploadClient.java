package com.zhu.network_program.tcpprogram.upload;

import com.zhu.network_program.tcpprogram.upload.utils.StreamUtils;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;


/**
 * @author: ZHUXIAOKANG
 * @date: 2022/1/17 0:24
 * @description:
 */
public class TCPFileUploadClient {
    /*
    1.编写一个服务端,一个客户端
    2.服务端在9999端口监听
    3.客户端连接到服务器端,发送一张图片d:\\socketTCP编程入门.png
    4.服务器端接收到客户端发送的图片,保存到src下,并发送"收到图片",再退出
    5.客户端接收到服务端发送的"收到图片",再退出
    6.该程序要求使用StreamUtils.java,我们直接使用
     */
    public static void main(String[] args) throws Exception {
        //客户端连接服务端9999,得到socket对象
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        //创建读取磁盘文件的输入流
        //读取本机d盘图片
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("D:\\socketTCP编程入门.png"));
        //把文件读到一个字节数组,使用工具类
        //bytes就是文件对应的字节数组
        byte[] bytes = StreamUtils.streamToByteArray(bis);
       //获取socket的输出流发送图片给服务端
       // OutputStream outputStream = socket.getOutputStream();
        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
        bos.write(bytes);//将文件对应的字节数组的内容,写入到数据通道
        //关流
        bis.close();
        //因为是二进制的,所以设置写入数据结束标志,不然服务端读不到(卡顿)
        socket.shutdownOutput();
        //============接收从服务端回复的消息

        //读取服务端传送的消息
        InputStream inputStream = socket.getInputStream();
        String s = StreamUtils.streamToString(inputStream);
        System.out.println(s);
        //关闭流和socket
        inputStream.close();
        bos.close();
        socket.close();
        System.out.println("客户端退出");


    }
}
