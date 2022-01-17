package com.zhu.network_program.tcpprogram;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/11/18 22:40
 * @description:
 */
public class SocketTCP02Server {
    /*
        1.编写一个服务端,一个客户端
        2.服务端在9999端口监听
        3.客户端连接到服务器端,发送"hello , server",并接收服务器端回发的
        "hello,client",再退出
        4.服务器端接收到客户端发送的信息,输出,并发送"hello,client",再退出
     */
    public static void main(String[] args) throws IOException {
        //思路
        //1. 在本机 的 9999 端口监听, 等待连接
        // 细节: 要求在本机没有其它服务在监听 9999
        // 细节：这个 ServerSocket 可以通过 accept() 返回多个 Socket[多个客户端连接服务器的并发]
        ServerSocket serverSocket = new ServerSocket(9999);
        //2. 当没有客户端连接 9999 端口时，程序会 阻塞, 等待连接
        // 如果有客户端连接，则会返回 Socket 对象，程序继续
        Socket socket = serverSocket.accept();
        //3. 通过 socket.getInputStream() 读取客户端写入到数据通道的数据, 显示
        InputStream inputStream = socket.getInputStream();
        //4. IO 读取
        byte[] buf = new byte[1024];
        int readLen = 0;
        while ((readLen = inputStream.read(buf)) != -1) {
            //根据读取到的实际长度，显示内容.
            System.out.println(new String(buf, 0, readLen));
        }
        //5. 获取 socket 相关联的输出流
        //服务端发送hello,client
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("hello,client".getBytes());

        // 设置写入结束标记,表示后面没有数据写入
        socket.shutdownOutput();
        //6.关闭流和 socket
        inputStream.close();
        outputStream.close();
        socket.close();
        serverSocket.close();//关闭

    }
}

