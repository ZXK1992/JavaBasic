package com.zhu.network_program.tcpprogram;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/11/18 22:40
 * @description:
 */
public class SocketTCP01Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
     /*   OutputStream outputStream = socket.getOutputStream();
        outputStream.write("hello client".getBytes());
        outputStream.close();
        socket.close();*/

    }
}
