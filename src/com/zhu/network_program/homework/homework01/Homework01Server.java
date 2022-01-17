package com.zhu.network_program.homework.homework01;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author: ZHUXIAOKANG
 * @date: 2022/1/17 23:58
 * @description:
 */
public class Homework01Server {
    public static void main(String[] args) throws IOException {
        //创建serversocket对象监听
        ServerSocket serverSocket = new ServerSocket(6666);
        Socket socket = serverSocket.accept();
        InputStream inputStream = socket.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        String s = br.readLine();
        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(outputStream));
        System.out.println("客户端消息为:" + s);
        //用一个变量接收不同的回答,根据客户端传来的消息
        String answer = "";
        if ("name".equals(s)) {
            answer = "我是nova";
        } else if ("hobby".equals(s)) {
            answer = "编写Java程序";
        } else {
            answer = "你说啥呢";
        }
        bw.write(answer);
        bw.flush();
        br.close();
        socket.close();
        serverSocket.close();
    }


}

