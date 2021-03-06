package com.zhu.network_program.tcpprogram;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author: ZHUXIAOKANG
 * @date: 2022/1/16 22:47
 * @description:
 */
public class SocketTCP01Client_ {
    public static void main(String[] args) throws IOException {
        //思路
        //1. 连接服务端 (ip , 端口）
        //解读: 连接本机的 9999 端口, 如果连接成功，返回 Socket 对象
        //客户端与本机的9998端口建立连接
        Socket socket = new Socket(InetAddress.getLocalHost().getHostName(),9998);
        System.out.println("客户端 socket 返回=" + socket.getClass());
        //2. 连接上后，生成 Socket, 通过 socket.getOutputStream()
        // 得到 和 socket 对象关联的输出流对象
        //3. 通过输出流，写入数据到 数据通道
        //socket获取输出流
        OutputStream outputStream = socket.getOutputStream();
        //发送消息(即输出消息给服务端)
        outputStream.write("hello server".getBytes());
        //关闭流,关闭socket
        //4. 关闭流对象和 socket, 必须关闭
        outputStream.close();
        socket.close();
    }

}
