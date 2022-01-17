package com.zhu.network_program.tcpprogram;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/11/18 22:40
 * @description:
 */
public class SocketTCP03Server {
    /*
    (使用字符流)
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
        InputStreamReader isr = new InputStreamReader(inputStream, "utf-8");
        BufferedReader br = new BufferedReader(isr);
        //4. IO 读取,使用字符流, 老师使用 InputStreamReader 将 inputStream 转成字符流
        String s = br.readLine();
        System.out.println(s);//输出
        //5. 获取 socket 相关联的输出流
        //服务端发送hello,client
        OutputStream outputStream = socket.getOutputStream();
        OutputStreamWriter osw = new OutputStreamWriter(outputStream, "utf-8");
        BufferedWriter bw = new BufferedWriter(osw);
        bw.write("hello,client,字符流");
        bw.newLine();// 插入一个换行符，表示回复内容的结束
        bw.flush();//注意需要手动的 flush
        //6.关闭流和 socket
        bw.close();
        br.close();
        socket.close();
        serverSocket.close();//关闭

    }
}

