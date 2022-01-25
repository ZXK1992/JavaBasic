package com.zhu.network_program.homework.homework03;

import com.zhu.network_program.homework.homework03.utils.StreamUtils;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * @author: ZHUXIAOKANG
 * @date: 2022/1/25 16:20
 * @description: 模拟TCP之文件下载客户端
 */
public class Homework03Client_ {
    /**
     *        1.编写客户端程序和服务端程序
     *        2.客户端可以输入一个音乐文件名,比如高山流水,服务端,收到音乐名后,可以给
     *        客户端返回这个音乐文件,如果服务器没有这个文件,返回一个默认的音乐即可
     *        3.客户端收到文件后,保存到本地D:\\
     *        4.提示:该程序可以使用StreamUtils.java
     */
    public static void main(String[] args) throws Exception {
        //1.创建scanner对象接收用户输入的指定下载文件
        Scanner scanner = new Scanner(System.in);
        //提示信息
        System.out.println("请输入要下载的文件名:");
        String downLoadFileName = scanner.next();
        //2.连接服务端准备发送文件名
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        //3.发送和socket关联的输出流
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write(downLoadFileName.getBytes());
        socket.shutdownOutput();//必须设置一个写入结束标志

        //4.读取服务端返回的文件(字节数据)
        InputStream inputStream = socket.getInputStream();
        BufferedInputStream bis = new BufferedInputStream(inputStream);
        byte[] bytes = StreamUtils.streamToByteArray(bis);
        inputStream.close();
        //5.得到一个输出流,准备将字节数据写入到磁盘保存
        //比如你下载的是高山流水 = > 下线的就是 高山流水.mp3
        //比如你下载的是aaa = > 下线的就是 无名.mp3, 文件名aaa.mp3
        String filePath = "D:\\" + downLoadFileName + ".mp3";
        BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream(filePath));
        bos.write(bytes);
        //6.关流及socket
        bos.close();
        bis.close();
        outputStream.close();
        socket.close();
        System.out.println("下载完毕,退出");

    }
}
