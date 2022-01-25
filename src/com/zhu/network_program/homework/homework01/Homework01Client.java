package com.zhu.network_program.homework.homework01;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author: ZHUXIAOKANG
 * @date: 2022/1/17 23:58
 * @description:
 */
public class Homework01Client {
    /*
        (1)使用字符流的方式,编写一个人客户端程序和服务端程序
    (2)客户端发送"name",服务器端接收到后,返回"我是nova",nova是你自己名字
    (3)客户端发送hobby,服务器端接收到后,返回编写java程序
    (4.)不是这两个问题,回复你说啥呢
    问题:目前,我们只能问一次,就退出,怎么可以问多次? ->while ->聊天
     */
    public static void main(String[] args) throws IOException {
        //创建socket对象连接服务端
        //Socket socket = new Socket(InetAddress.getLocalHost().getHostName(), 6666);
        Socket socket = new Socket(InetAddress.getByName("192.168.203.129"), 6666);
        OutputStream outputStream = socket.getOutputStream();
        //使用字符流发送
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(outputStream));
        InputStream inputStream = socket.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要发送的内容");
        String next = scanner.next();
        bw.write(next);
        bw.newLine();
        bw.flush();
        String s = br.readLine();
        System.out.println("服务端回复为:" + s);
        br.close();
        socket.close();

    }
}
