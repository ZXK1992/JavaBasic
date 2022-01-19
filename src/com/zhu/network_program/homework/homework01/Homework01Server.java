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
    /*
    (1)使用字符流的方式,编写一个人客户端程序和服务端程序
    (2)客户端发送"name",服务器端接收到后,返回"我是nova",nova是你自己名字
    (3)客户端发送hobby,服务器端接收到后,返回编写java程序
    (4.)不是这两个问题,回复你说啥呢
    问题:目前,我们只能问一次,就退出,怎么可以问多次? ->while ->聊天
     */
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

