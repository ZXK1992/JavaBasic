package com.zhu.network_program.tcpprogram.upload;

import com.zhu.network_program.tcpprogram.upload.utils.StreamUtils;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author: ZHUXIAOKANG
 * @date: 2022/1/18 22:12
 * @description: 模拟文件上传客户端
 */
public class TCPFileUploadClient_ {
    public static void main(String[] args) throws Exception {
        //1.连接服务端8888端口,得到socket对象
        Socket socket = new Socket(InetAddress.getLocalHost().getHostName(), 8888);
        //2.创建读取磁盘文件的输入流
        String srcFilePath="D:\\位运算练习.png";
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(srcFilePath));
        //3.得到图片对应的字节数组(使用工具类得到)
        byte[] bytes = StreamUtils.streamToByteArray(bis);
        //关流
        bis.close();
        //4.通过socket获取到输出流,将bytes数组发送给服务端
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write(bytes);
        socket.shutdownOutput();
        //5.通过socket获取输入流,接收服务端的数据(服务端上传成功会回复)
        InputStream inputStream = socket.getInputStream();
        //(使用工具类得到)
        String s = StreamUtils.streamToString(inputStream);
        //显示服务端发来的
        System.out.println(s);
        //6.关流
        inputStream.close();
        outputStream.close();
        socket.close();



    }
}
