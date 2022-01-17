package com.zhu.network_program.tcpprogram;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/11/18 22:40
 * @description:
 */
public class SocketTCP02Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        //2.连接上后,生成socket,通过socket.getOutputStream()
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("hello server".getBytes());
        //设置写入结束标记,表示后面没有数据写入
        socket.shutdownOutput();
        //获取和socket关联的输入流,读取数据(字节),并显示
        //并接收服务器端回发的"hello,client",再退出
        InputStream inputStream = socket.getInputStream();
        byte[] buf = new byte[1024];
        int readLen = 0;
        while ((readLen = inputStream.read(buf)) != -1) {
            //根据读取到的实际长度，显示内容.
            System.out.println(new String(buf, 0, readLen));
        }
        inputStream.close();
        outputStream.close();
        socket.close();

    }
}
