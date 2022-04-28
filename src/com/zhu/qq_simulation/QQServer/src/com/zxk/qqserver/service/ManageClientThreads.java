package com.zhu.qq_simulation.QQServer.src.com.zxk.qqserver.service;

import java.util.HashMap;
import java.util.Iterator;

/**
 * @author: ZHUXIAOKANG
 * @date: 2022/1/30 2:15
 * @description: 该类用于管理和客户端通信的线程
 */
public class ManageClientThreads {

    private static HashMap<String,ServerConnectClientThread> hm = new HashMap<>();
    //getter方法
    public static HashMap<String, ServerConnectClientThread> getHm() {
        return hm;
    }

    //添加线程对象到hm集合
    public static void addServerConnectClientThread(String userId, ServerConnectClientThread serverConnectClientThread) {
        hm.put(userId,serverConnectClientThread);
    }
    //获取线程对象
    public static ServerConnectClientThread getServerConnectClientThread(String userId){
        return hm.get(userId);
    }

    //返回在线用户列表
    public static String getOnlineUser(){
        String content="";
        Iterator<String> iterator = hm.keySet().iterator();
        while (iterator.hasNext()) {
            String u = iterator.next();
            content+=u+" ";
        }
        return content;
    }

    public static void removeServerConnectClientThread(String userId) {
        hm.remove(userId);
    }
}
