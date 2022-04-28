package com.zhu.qq_simulation.QQClient.src.com.zxk.qqclient.service;

import java.util.HashMap;

/**
 * @author: ZHUXIAOKANG
 * @date: 2022/1/29 23:00
 * @description:
 * 该类管理客户端连接到服务器端的线程类
 */
public class ManageClientConnectServerThread {
    //我们把多个线程放入一个HashMap集合,key就是用户id,value是线程
    private static HashMap<String ,ClientConnectServerThread> hm =new HashMap<>();
    //我们把多个线程放入一个HashMap集合,key就是用户id,value是线程
    public static void addClientConnectServerThread(String userId , ClientConnectServerThread clientConnectServerThread){
        hm.put(userId, clientConnectServerThread);
    }
    //获取方法
    public static ClientConnectServerThread getClientConnectServerThread(String userId ){
        return  hm.get(userId);
    }
}
