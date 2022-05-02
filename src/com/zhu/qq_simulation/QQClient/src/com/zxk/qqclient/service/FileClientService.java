package com.zhu.qq_simulation.QQClient.src.com.zxk.qqclient.service;



import com.zhu.qq_simulation.QQClient.src.com.zxk.qqcommon.Message;
import com.zhu.qq_simulation.QQClient.src.com.zxk.qqcommon.MessageType;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;

/**
 * @author: ZHUXIAOKANG
 * @date: 2022/4/26 22:11
 * @description: 该类完成文件传输
 */
public class FileClientService {

    /**
     * @param senderId
     * @param fileGetId
     * @param src       源文件
     * @param dest      把该文件传输到对方的哪个目录
     */
    public void sendFileToOne(String senderId, String fileGetId, String src, String dest) {
        //读取src文件--->message
        //创建mess
        Message message = new Message();
        message.setMesType(MessageType.MESSAGE_TOONE_FILE);
        message.setSender(senderId);
        message.setGetter(fileGetId);
        message.setSrc(src);
        message.setDest(dest);
        //需要将文件读取
        BufferedInputStream bis = null;
        try {
            bis = new BufferedInputStream(new FileInputStream(src));
            //把文件读取到客户端，字节数组
            byte[] fileBytes = new byte[(int)new File(src).length()];
           bis.read(fileBytes);//将src文件读入到程序的字节数组
            message.setBytes(fileBytes);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
           if (bis!=null){
               try {
                   bis.close();
               } catch (IOException e) {
                   e.printStackTrace();
               }
           }
        }
        System.out.println("\n"+senderId+"给"+fileGetId+"发送文件："+src+"到对方的电脑的目录"+dest);
        //将mess发送给服务端
        try {
            ObjectOutputStream oos = new ObjectOutputStream(ManageClientConnectServerThread
                    .getClientConnectServerThread(senderId).getSocket().getOutputStream());
            oos.writeObject(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
