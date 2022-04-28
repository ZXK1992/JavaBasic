package com.zhu.qq_simulation.QQClient.src.com.zxk.qqclient.service;

import com.zxk.qqcommon.Message;
import com.zxk.qqcommon.MessageType;
import com.zxk.qqcommon.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author: ZHUXIAOKANG
 * @date: 2022/1/27 16:25
 * @description: 该类完成登录验证和用户注册的功能
 */
public class UserClientService {
    //因为其他地方要使用user
    private User u = new User();
    //因为其他地方要使用socket
    private Socket socket;

    /**
     * 根据UserId,pwd到服务器端验证该用户双是否合法
     *
     * @param userId
     * @param pwd
     * @return
     */
    public boolean checkUser(String userId, String pwd) {
        boolean b = false;
        //1.创建user对象
        u.setUserId(userId);
        u.setPwd(pwd);
        try {
            //2.连接到服务端
            socket = new Socket(InetAddress.getByName("127.0.0.1"), 9999);
            //3.得到ObjectOutputStream对象
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            //4.发送user对象
            oos.writeObject(u);
            //5.读取,从服务端回复的message对象
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            Message mes = (Message) ois.readObject();
            //
            if (mes.getMesType().equals(MessageType.MESSAGE_LOGIN_SUCCED)) {//登录OK
                //创建一个和服务端保持通信的线程--> 创建一个类ClientConnectServerThread
                ClientConnectServerThread clientConnectServerThread = new ClientConnectServerThread(socket);
                clientConnectServerThread.start();
                //这里为了客户端方便管理,用集合管理线程
                ManageClientConnectServerThread.addClientConnectServerThread(u.getUserId(), clientConnectServerThread);
                b = true;
            } else {//登录失败,我们就不能启动线程,要关闭socket
                socket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return b;

    }

    //向服务端请求在线用户列表
    public void onlineFriendList() {
       //发送Message
            Message message = new Message();
            message.setMesType(MessageType.MESSAGE_GET_ONLINE_FRIEND);
            message.setSender(u.getUserId());
        try {
            //发送给服务器
            //从管理线程的集合中通过userid得到线程
            ClientConnectServerThread clientConnectServerThread =
                    ManageClientConnectServerThread.getClientConnectServerThread(u.getUserId());
            //由线程得到socket
            Socket socket = clientConnectServerThread.getSocket();
            //由socket创建对象输出流
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            //发送message对象向服务端要求在线用户列表
            oos.writeObject(message);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //退出客户端
    public void logout() {
        //发送给服务端的退出系统的信息
        Message message = new Message();
        message.setMesType(MessageType.MESSAGE_CLIENT_EXIT);
        //指定我是哪个客户端
        message.setSender(u.getUserId());
        //发送信息
        try {
            //ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            ObjectOutputStream oos = new ObjectOutputStream(ManageClientConnectServerThread
                    .getClientConnectServerThread(u.getUserId()).getSocket().getOutputStream());
            oos.writeObject(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(u.getUserId()+"退出");
        //退出程序
        System.exit(0);
    }
}
