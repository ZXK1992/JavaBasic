package com.zhu.network_program.udpprogam;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * @author: ZHUXIAOKANG
 * @date: 2022/1/19 0:07
 * @description: 发送端 B ====> 也可以接收数据
 */
public class UDPSenderB {
    /*
    1.编写一个接收端A和一个发送端B
    2.接收端A在9999端口等待接收数据(receive)
    3.发送端B向接收端A发送数据"hello,明天吃火锅.."
    4.接收端A接收到发送端B发送的数据,回复"好的,明天见",再退出
    5.发送端接收回复数据,在退出
     */
    public static void main(String[] args) throws IOException {
        //1.创建DatagramSocket对象,准备在9998端口接收数据
        DatagramSocket socket = new DatagramSocket(9998);
        //发送端B向接收端A发送数据"hello,明天吃火锅.."
        byte[] data = "hello,明天吃火锅..".getBytes();
        //2.将需要发送的数据,封装到DatagramPacket对象
        //参数:发送的内容字节数组,数组长度,接收方的主机地址,接收方的端口
        //说明: 封装的 DatagramPacket 对象 data 内容字节数组 , data.length , 主机(IP) , 端口
        DatagramPacket packet =
                new DatagramPacket(data,  data.length, InetAddress.getByName("192.168.0.107"),9999);
        //3.发送
        socket.send(packet);

        //4.==接收A端的回复信息
        //让data指向接收的数据,字节数组
        // 在前面讲解 UDP 协议时，老师说过一个数据包最大 64k
        byte[] buf = new byte[1024];
        /*packet.setData(reply);
        socket.receive(packet);*/
        //(1) 构建一个 DatagramPacket 对象，准备接收数据
        packet=new DatagramPacket(buf,buf.length);
        //(2) 调用 接收方法, 将通过网络传输的 DatagramPacket 对象
        // 填充到 packet 对象
        //老师提示: 当有数据包发送到 本机的 9998 端口时，就会接收到数据
        // 如果没有数据包发送到 本机的 9998
        socket.receive(packet);
        //(3) 可以把 packet 进行拆包，取出数据，并显示.
        data=packet.getData();//接收到数据
        String s = new String(data);
        System.out.println(s);
        //4.关闭资源
        socket.close();
        System.out.println("B端退出");


    }
}
