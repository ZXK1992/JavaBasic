package com.zhu.network_program.tcpprogram.upload;

import com.zhu.network_program.tcpprogram.upload.utils.StreamUtils;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author: ZHUXIAOKANG
 * @date: 2022/1/18 22:11
 * @description: 模拟文件上传服务端
 */
public class TCPFileUploadServer_ {
    public static void main(String[] args) throws Exception {
        //1.编写监听8888端口
        ServerSocket serverSocket = new ServerSocket(8888);
        System.out.println("服务端监听...");
        //2.等待客户端连接
        Socket socket = serverSocket.accept();
        //3.读取客户端发送的数据
        InputStream inputStream = socket.getInputStream();
        //4.使用工具类,传入InputStream得到字节数组,即为客户端所传图片数据
        byte[] bytes = StreamUtils.streamToByteArray(inputStream);
        //将得到的bytes数组写入指定的上传路径
        String destFilePath = "src\\位运算练习.png";
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destFilePath));
        bos.write(bytes);
        //关流
        bos.close();
        //通过socket得到输出流用于回复客户端上传成功
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("收到图片".getBytes());
        //设置结束标记
        socket.shutdownOutput();
        //关闭流和socket
        outputStream.close();
        inputStream.close();
        socket.close();
        serverSocket.close();

    }
}
