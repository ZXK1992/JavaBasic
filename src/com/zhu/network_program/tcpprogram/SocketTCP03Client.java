package com.zhu.network_program.tcpprogram;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/11/18 22:40
 * @description:
 */
public class SocketTCP03Client {
    public static void main(String[] args) throws IOException {
        //1. 连接服务端 (ip , 端口）
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        //2. 连接上后，生成 Socket, 通过 socket.getOutputStream()
        OutputStream outputStream = socket.getOutputStream();
        //3.通过输出流，写入数据到 数据通道, 使用字符流
        OutputStreamWriter osw = new OutputStreamWriter(outputStream, "utf-8");
        BufferedWriter bw = new BufferedWriter(osw);
        bw.write("hello server");
        bw.newLine();// 插入一个换行符，表示回复内容的结束
        bw.flush();// 如果使用的字符流，需要手动刷新，否则数据不会写入数据通道
        //并接收服务器端回发的"hello,client",再退出
        // 4. 获取和 socket 关联的输入流. 读取数据(字符)，并显示
        InputStream inputStream = socket.getInputStream();
        InputStreamReader isr = new InputStreamReader(inputStream, "utf-8");
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        System.out.println(s);
        //5.关闭流对象(外层流)和 socket, 必须关闭
        br.close();
        bw.close();
        socket.close();
        System.out.println("客户端退出.....");
    }
}
