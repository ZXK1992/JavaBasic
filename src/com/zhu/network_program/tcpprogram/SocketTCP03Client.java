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
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        OutputStream outputStream = socket.getOutputStream();
        OutputStreamWriter osw = new OutputStreamWriter(outputStream, "utf-8");
        BufferedWriter bw = new BufferedWriter(osw);
        bw.write("hello server");
        bw.newLine();// 插入一个换行符，表示回复内容的结束
        bw.flush();// 如果使用的字符流，需要手动刷新，否则数据不会写入数据通道
        //并接收服务器端回发的"hello,client",再退出
        InputStream inputStream = socket.getInputStream();
        InputStreamReader isr = new InputStreamReader(inputStream, "utf-8");
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        System.out.println(s);
        br.close();
        bw.close();
        socket.close();
        System.out.println("客户端退出.....");
    }
}
