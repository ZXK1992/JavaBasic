package com.zhu.qq_simulation.QQClient.src.com.zxk.qqclient.service;

import com.zxk.qqcommon.Message;
import com.zxk.qqcommon.MessageType;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;

/**
 * @author: ZHUXIAOKANG
 * @date: 2022/4/26 14:19
 * @description:
 */
public class MessageClientService {

    public  void sendMessageToOne(String content, String senderId, String getterId) {
        //构建message对象
        Message message = new Message();
        message.setSender(senderId);
        message.setMesType(MessageType.MESSAGE_COMM);
        message.setGetter(getterId);
        message.setContent(content);
        message.setSendTime(new Date().toString());
        System.out.println(message.getSendTime()+" "+ senderId+"对 "+getterId+"说："+content);
        //发送给服务端
        try {
            ObjectOutputStream oos = new ObjectOutputStream(ManageClientConnectServerThread
                    .getClientConnectServerThread(senderId).getSocket().getOutputStream());
            oos.writeObject(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMessageToAll(String toAllCont, String senderId) {
        //构建message对象
        Message message = new Message();
        message.setSendTime(new Date().toString());
        message.setContent(toAllCont);
        message.setSender(senderId);
        //消息类型
        message.setMesType(MessageType.MESSAGE_TOALL_MES);
        System.out.println(message.getSendTime()+" "+senderId+"对大家说："+toAllCont);
        //序列化
        try {
            ObjectOutputStream oos = new ObjectOutputStream(ManageClientConnectServerThread
                    .getClientConnectServerThread(senderId).getSocket().getOutputStream());
            oos.writeObject(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendOfflineToOne(String offlineId,String senderId, String offlineContent) {
        //构建message对象
        Message message = new Message();
        message.setSender(senderId);
        message.setMesType(MessageType.MESSAGE_OFFLINE_MES);
        message.setGetter(offlineId);
        message.setContent(offlineContent);
        message.setSendTime(new Date().toString());
        System.out.println(message.getSendTime()+" "+ senderId+"对离线用户 "+offlineId+"说："+offlineContent);
        //发送给服务端
        try {
            ObjectOutputStream oos = new ObjectOutputStream(ManageClientConnectServerThread
                    .getClientConnectServerThread(senderId).getSocket().getOutputStream());
            oos.writeObject(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
