package com.zhu.qq_simulation.QQClient.src.com.zxk.qqclient.service;


import com.zhu.qq_simulation.QQClient.src.com.zxk.qqcommon.Message;
import com.zhu.qq_simulation.QQClient.src.com.zxk.qqcommon.MessageType;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.net.Socket;

/**
 * @author: ZHUXIAOKANG
 * @date: 2022/1/27 20:33
 * @description:
 */
public class ClientConnectServerThread extends Thread {
    //该线程持有socket
    private Socket socket;

    //构造器,可以接收一个socket对象
    public ClientConnectServerThread(Socket socket) {
        this.socket = socket;
    }

    //为了更方便得到socket对象,提供get方法
    public Socket getSocket() {
        return socket;
    }

    //run方法作用,因为线程需要在后台和服务器端通信,异常用while循环
    //一直读取从服务器端的message,客户端线程得到从服务器端读取信息
    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("\n客户端线程,等待读取从服务器端发送的消息 ");
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                //如果服务器没有发送Message对象.线程会阻塞在readObject这里
                Message m = (Message) ois.readObject();
                //注意,后面需要使用message
                //判断这个message类型然后做相应的业务处理
                if (MessageType.MESSAGE_RET_ONLINE_FRIEND.equals(m.getMesType())) {//如果读取的是服务端返回的在线用户列表
                    //取出在线用户列表并返回
                    String content = m.getContent();
                    String[] onlineUsers = content.split(" ");
                    System.out.println("\n=============当前在线用户列表=============");
                    for (int i = 0; i < onlineUsers.length; i++) {
                        System.out.println("用户：" + onlineUsers[i]);
                    }
                } else if (MessageType.MESSAGE_COMM.equals(m.getMesType())) {
                    //把从服务端转化的信息显示控制台
                    System.out.println("\n " + m.getSendTime() + " " + m.getSender() + "对" + m.getGetter() + "说: " + m.getContent());
                } else if (MessageType.MESSAGE_TOALL_MES.equals(m.getMesType())) {
                    //把从服务端转化的信息显示控制台
                    System.out.println("\n " + m.getSendTime() + " " + m.getSender() + "对大家说: " + m.getContent());
                } else if (MessageType.MESSAGE_TOONE_FILE.equals(m.getMesType())) {
                    //在接收到包含有文件的消息后将该文件保存磁盘
                    System.out.println("\n " + m.getSender() + "给 " + m.getGetter() + "发送文件："+m.getSrc()
                            +"到我的电脑目录"+m.getDest());
                    //取出m的文件字节数组，通过文件输出流写出到磁盘
                    BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(m.getDest()));
                    bos.write(m.getBytes());
                    bos.close();
                    System.out.println("文件保存成功");
                } else if (MessageType.MESSAGE_OFFLINE_MES.equals(m.getMesType())) {
                    System.out.println("\n " + m.getSendTime() + " " + m.getSender() + "对" + m.getGetter() + "说: " + m.getContent());
                }else {
                    System.out.println("其他类型信息暂不处理");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}

