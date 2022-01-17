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
    public static void main(String[] args) throws IOException {
        //创建socket对象连接服务端
        Socket socket = new Socket(InetAddress.getLocalHost().getHostName(), 6666);
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
