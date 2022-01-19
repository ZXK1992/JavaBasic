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
       //1.服务端在9999端口监听
        ServerSocket serverSocket = new ServerSocket(9999);
        //2.等待客户端连接
        Socket socket = serverSocket.accept();
        //3.读取客户端发送的图片
        BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
        //bytes就是文件对应的字节数组(使用工具类获取)
        byte[] bytes = StreamUtils.streamToByteArray(bis);
        //将得到bytes数组,写入到指定的路径,就得到一个文件了
        //创建输出流写入到(保存到)src
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("src\\高山流水.mp3"));
        bos.write(bytes);
        bos.close();
      /*  OutputStream outputStream = socket.getOutputStream();
        outputStream.write("收到图片".getBytes());
        socket.shutdownOutput();
        outputStream.close();*/
        //向客户端回复"收到图片"
        //通过socket 获取到输出流(字符流)
        BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bw.write("收到图片");
        bw.flush();//把内容刷新到数据通道(如果没有刷新是不会写入到通道)
        socket.shutdownOutput();//设置写入接结束标记
        //关闭其他资源
        bw.close();
        bis.close();
        socket.close();
        serverSocket.close();


    }
}
