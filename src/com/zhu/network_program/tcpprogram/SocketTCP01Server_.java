package com.zhu.network_program.tcpprogram;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author: ZHUXIAOKANG
 * @date: 2022/1/16 22:43
 * @description:
 */
public class SocketTCP01Server_ {
    public static void main(String[] args) throws IOException {
        //思路
        //1. 在本机 的 9998 端口监听, 等待连接
        // 细节: 要求在本机没有其它服务在监听 9999
        // 细节：这个 ServerSocket 可以通过 accept() 返回多个 Socket[多个客户端连接服务器的并发]
        //服务端在9998端口监听
        ServerSocket serverSocket = new ServerSocket(9998);
        System.out.println("服务端在9998端口监听,等待连接");
        //2.等待客户端连接,没有客户端连接会阻塞
        // 如果有客户端连接，则会返回 Socket 对象，程序继续
        Socket socket = serverSocket.accept();
        System.out.println("客户端连接");
        System.out.println("服务端 socket =" + socket.getClass());

        //接收消息(输入流)
        //3.通过socket.getInputStream()读取客户端写入到数据通道的数据
        InputStream inputStream = socket.getInputStream();
        //4.IO读取
        //一次读取的长度
        int readLen=0;
        //一次读取的字节数组
        byte []buf = new byte[1024];
        while ((readLen = inputStream.read(buf))!=-1){
            System.out.print(new String(buf,0,readLen));//根据读取到的实际长度，显示内容.
        }
        //5.关流和socket
        inputStream.close();
        socket.close();
        serverSocket.close();//关闭
    }
}
