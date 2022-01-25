package com.zhu.network_program.homework.homework03;

import com.zhu.network_program.homework.homework03.utils.StreamUtils;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author: ZHUXIAOKANG
 * @date: 2022/1/20 15:07
 * @description:
 */
public class Homework03Server {
    /*
       1.编写客户端程序和服务端程序
       2.客户端可以输入一个音乐文件名,比如高山流水,服务端,收到音乐名后,可以给
       客户端返回这个音乐文件,如果服务器没有这个文件,返回一个默认的音乐即可
       3.客户端收到文件后,保存到本地D:\\
       4.提示:该程序可以使用StreamUtils.java

     */
    public static void main(String[] args) throws Exception {
        //1.创建ServerSocket对象,在端口6666接收消息
        ServerSocket serverSocket = new ServerSocket(6666);
        //等待
        Socket socket = serverSocket.accept();
        InputStream inputStream = socket.getInputStream();
        //2.读取客户端的信息
        byte[] bytes = StreamUtils.streamToByteArray(inputStream);
        String s = new String(bytes);
        System.out.println(s);
        //3.根据客户端的音乐名查找是否有该音乐
        String filePath = "src\\com\\zhu\\network_program\\homework\\homework03\\musics";
        File parFile = new File(filePath);
        File file = new File(parFile, s+"mp3");
        //创建读取音乐的流
        BufferedInputStream bio = null;
        //4.用socket创建发给客户端的输出流
        OutputStream outputStream = socket.getOutputStream();
        BufferedOutputStream bos = new BufferedOutputStream(outputStream);
        if (file.exists()) {
            bio = new BufferedInputStream((new FileInputStream(filePath + s)));
        } else {
            filePath = "src\\com\\zhu\\network_program\\homework\\homework03\\default\\无名.mp3";
            bio = new BufferedInputStream((new FileInputStream(filePath)));

        }
        byte[] bytes1 = StreamUtils.streamToByteArray(bio);
        bos.write(bytes1);
        bos.close();
        //关闭资源

        bio.close();
        socket.close();
        serverSocket.close();
    }
}
