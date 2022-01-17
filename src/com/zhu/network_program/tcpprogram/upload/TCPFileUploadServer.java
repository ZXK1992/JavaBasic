package com.zhu.network_program.tcpprogram.upload;

import com.zhu.network_program.tcpprogram.upload.utils.StreamUtils;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author: ZHUXIAOKANG
 * @date: 2022/1/17 0:24
 * @description:
 */
public class TCPFileUploadServer {
    /*

   1.编写一个服务端,一个客户端
    2.服务端在9999端口监听
    3.客户端连接到服务器端,发送一张图片d:\\socketTCP编程入门.png
    4.服务器端接收到客户端发送的图片,保存到src下,并发送"收到图片",再退出
    5.客户端接收到服务端发送的"收到图片",再退出
    6.该程序要求使用StreamUtils.java,我们直接使用
 */
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(9999);
        Socket socket = serverSocket.accept();
        //读取客户端发送的图片
        InputStream inputStream = socket.getInputStream();
        byte[] bytes = StreamUtils.streamToByteArray(inputStream);
        //创建输出流写入到(保存到)src
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("src\\socketTCP编程入门.png"));
        bos.write(bytes);
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("收到图片".getBytes());
        socket.shutdownOutput();
        outputStream.close();
        bos.close();
        inputStream.close();
        socket.close();
        serverSocket.close();


    }
}
