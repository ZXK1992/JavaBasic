package com.zhu.network_program.homework.homework02;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

/**
 * @author: ZHUXIAOKANG
 * @date: 2022/1/19 23:43
 * @description:
 */
public class Homework02ReceiverA {
    /*
    1.编写一个接收端A,和一个发送端B,使用UDP协议完成
    2.接收端在8888端口等待接收数据(receive)
    3.发送端向接收端发送数据"四大名著是哪些"
    4.接收端接收到发送端发送的问题后,返回"四大名著是<<红楼梦>>..."
      否则返回what?
    5.接收端和发送端程序退出

     */
    public static void main(String[] args) throws IOException {
        //1.接收端在8888端口等待接收数据,构建DatagramSocket对象
        DatagramSocket socket = new DatagramSocket(8888);
        //data数组用于存放接收的数据
        byte[] data = new byte[1024];
        DatagramPacket packet = new DatagramPacket(data, data.length);
        //System.out.println("接收端A等待接收数据");
        //接收数据
        socket.receive(packet);
        //拆包获取数据用data指向
        data = packet.getData();
        String s = new String(data).trim();
        System.out.println(s);
        //接收方回复
        //回复的数据字节数组
        String rightMes="四大名著是哪些";
        String mes = "";
        byte[]bytes=null;
        if (rightMes.equals(s)){
             mes="四大名著是<<红楼梦>>,<<西游记>>,<<三国演义>>,<<水浒传>>";
            bytes=mes.getBytes();
            //重新装包//构建DatagramPacket对象,接收方的主机地址,端口
            packet=new DatagramPacket(bytes,bytes.length, InetAddress.getByName("192.168.0.107"), 8887);
        }else{
            mes="what?";
            bytes=mes.getBytes();
            packet=new DatagramPacket(bytes,bytes.length, InetAddress.getByName("192.168.0.107"), 8887);
        }
        //发送消息(回复B端)
        socket.send(packet);
        socket.close();


    }
}
