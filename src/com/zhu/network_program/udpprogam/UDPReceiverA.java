package com.zhu.network_program.udpprogam;

import java.io.IOException;
import java.net.*;

/**
 * @author: ZHUXIAOKANG
 * @date: 2022/1/19 0:07
 * @description: 接收端A
 */
public class UDPReceiverA {
    /*
    1.编写一个接收端A和一个发送端B
    2.接收端A在9999端口等待接收数据(receive)
    3.发送端B向接收端A发送数据"hello,明天吃火锅.."
    4.接收端A接收到发送端B发送的数据,回复"好的,明天见",再退出
    5.发送端接收回复数据,在退出
     */
    public static void main(String[] args) throws IOException {
        //1.创建DatagramSocket对象,准备在9999端口接收数据
        DatagramSocket socket = new DatagramSocket(9999);
        //创建字节数组,后面接收的时候会填充接收数据到里面
        // 在前面讲解 UDP 协议时，老师说过一个数据包最大 64k
        byte[] data= new byte[1024];
        //构建DatagramPacket对象,准备接收数据
       DatagramPacket packet = new DatagramPacket(data,data.length);
        //老师提示: 当有数据包发送到 本机的 9999 端口时，就会接收到数据
//      如果没有数据包发送到 本机的 9999 端口, 就会阻塞等待.
        System.out.println("A端等待接收数据");
        //3. 调用 接收方法, 将通过网络传输的 DatagramPacket 对象
        //准备接收,如果有数据过来,会填充到DatagramPacket对象
        socket.receive(packet);
        //4. 可以把 packet 进行拆包，取出数据，并显示.
        int length = packet.getLength();//实际接收到的数据字节长度
        String s = new String(packet.getData());
        System.out.println(s);

        //=====回复信息给B端
      /*  packet.setData("好的,明天见".getBytes());
        packet.setPort(9998);
        packet.setAddress(InetAddress.getByName("192.168.0.107"));*/
        //让data指向要回复B端的字节数组
        //将需要发送的数据，封装到 DatagramPacket 对象
        data = "好的,明天见".getBytes();
        //端口为B的端口
        //说明: 封装的 DatagramPacket 对象 data 内容字节数组 , data.length , 主机(IP) , 端口
        packet=new DatagramPacket(data,data.length,InetAddress.getByName("192.168.0.107"),9998);
        socket.send(packet);
        //5.关闭资源
        socket.close();
        System.out.println("A端退出");
    }
}
