package com.zhu.network_program.homework.homework03;

import com.zhu.network_program.homework.homework03.utils.StreamUtils;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author: ZHUXIAOKANG
 * @date: 2022/1/25 16:20
 * @description: 模拟TCP之文件下载服务端
 */
public class Homework03Server_ {
    /*
       1.编写客户端程序和服务端程序
       2.客户端可以输入一个音乐文件名,比如高山流水,服务端,收到音乐名后,可以给
       客户端返回这个音乐文件,如果服务器没有这个文件,返回一个默认的音乐即可
       3.客户端收到文件后,保存到本地D:\\
       4.提示:该程序可以使用StreamUtils.java
     */
    public static void main(String[] args) throws Exception {
        //1.监听9999端口
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("服务端等待监听");
        //2.等待客户端连接
        Socket socket = serverSocket.accept();
        //3.读取,客户端发送要下载的文件名
        //这里使用while读取文件名,考虑到客户端发送的数据较大的情况
        InputStream inputStream = socket.getInputStream();
        int len = 0;
        byte[] b = new byte[1024];
        //得到需要下载的文件名
        String downLoadFileName = "";
        //考虑到以后接收的的内容比较多的情况用while
        while ((len = inputStream.read(b)) != -1) {
            downLoadFileName += new String(b, 0, len);
            ;
        }

        System.out.println("客户端希望下载得到文件名:"+downLoadFileName);
        //bis.close();
        //在服务端上有两个文件,无名.mp3,高山流水.mp3
        //如果客户下载的是高山流水,我们就返回该文件,否则一律返回 无名.mp3

        String musicPath = "src\\com\\zhu\\network_program\\homework\\homework03\\musics";
        String resFileName = "";
        if ("高山流水".equals(downLoadFileName)) {
            resFileName = musicPath + "\\高山流水.mp3";
        } else {
            resFileName = musicPath + "\\无名.mp3";
        }
        //4.并创建输入流读取该文件
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(resFileName));
        //5.使用工具类读取文件到一个字节数组
        byte[] bytes = StreamUtils.streamToByteArray(bis);
        //6.得到socket关联的输出流
        OutputStream outputStream = socket.getOutputStream();
        BufferedOutputStream bos = new BufferedOutputStream(outputStream);
        //7.写入到数据通道返回给客户端
        bos.write(bytes);
        //关键点,必须设置一个结束标志,因为是二进制的
        socket.shutdownOutput();
        //8.关流
        bis.close();
        inputStream.close();
        bos.close();
        outputStream.close();
        socket.close();
        serverSocket.close();
        System.out.println("服务端退出");


    }
}
