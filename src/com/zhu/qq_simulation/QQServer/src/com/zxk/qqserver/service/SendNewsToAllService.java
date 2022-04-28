package com.zhu.qq_simulation.QQServer.src.com.zxk.qqserver.service;



import com.zhu.qq_simulation.QQServer.src.com.zxk.qqcommon.Message;
import com.zhu.qq_simulation.QQServer.src.com.zxk.qqcommon.MessageType;
import com.zhu.qq_simulation.QQServer.src.com.zxk.qqserver.utils.Utility;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;

/**
 * @author: ZHUXIAOKANG
 * @date: 2022/4/28 22:03
 * @description:推送新闻/消息
 */
public class SendNewsToAllService implements Runnable{

    @Override
    public void run() {
        //为了可以多次推送新闻，用while循环
        while (true){
            System.out.println("请输入服务器要推送的新闻/消息[退出推送请输入exit]：");
            String news = Utility.readString(100);
            //退出推送请输入exit
            if ("exit".equals(news)){
                break;
            }
            Message message = new Message();
            message.setMesType(MessageType.MESSAGE_TOALL_MES);//群发消息类型
            message.setSender("服务器");
            message.setContent(news);
            message.setSendTime(new Date().toString());
            System.out.println("服务器推送消息给所有人说："+news);
            //遍历当前所有得到通信线程得到socket
            HashMap<String, ServerConnectClientThread> hm = ManageClientThreads.getHm();
            Iterator<String> iterator = hm.keySet().iterator();
            while (iterator.hasNext()) {
                String getterId = iterator.next();
                ServerConnectClientThread serverConnectClientThread = hm.get(getterId);
                try {
                    //群发消息
                    ObjectOutputStream oos = new ObjectOutputStream(serverConnectClientThread.getSocket().getOutputStream());
                    oos.writeObject(message);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }


    }
}
