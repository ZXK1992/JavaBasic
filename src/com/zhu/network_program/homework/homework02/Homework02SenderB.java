package com.zhu.network_program.homework.homework02;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

/**
 * @author: ZHUXIAOKANG
 * @date: 2022/1/19 23:44
 * @description:
 */
public class Homework02SenderB {
    /*
      1.编写一个接收端A,和一个发送端B,使用UDP协议完成
    2.接收端在8888端口等待接收数据(receive)
    3.发送端向接收端发送数据"四大名著是哪些"
    4.接收端接收到发送端发送的问题后,返回"四大名著是<<红楼梦>>..."
      否则返回what?
    5.接收端和发送端程序退出
     */
    public static void main(String[] args) throws IOException {
        //1.构建DatagramSocket对象,准备在8887端口,接收数据
        DatagramSocket socket = new DatagramSocket(8887);
        //2.准备发送的数据,封装到DatagramPacket对象
        System.out.println("输入你要问的问题:");
        Scanner scanner = new Scanner(System.in);
        String question = scanner.next();
        byte[] data=question.getBytes();
        //构建DatagramPacket对象,接收方的主机地址,端口
        DatagramPacket packet =
                new DatagramPacket(data, data.length, InetAddress.getByName("192.168.0.107"), 8888);
        socket.send(packet);

        //接收来着接收端A的回复消息
        byte []bytes=new byte[1024];
        packet=new DatagramPacket(bytes,bytes.length);
        socket.receive(packet);
        data=packet.getData();
        String s = new String(data);
        System.out.println(s);
        socket.close();

    }
}
