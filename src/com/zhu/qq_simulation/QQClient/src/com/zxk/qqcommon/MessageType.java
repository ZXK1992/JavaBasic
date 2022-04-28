package com.zhu.qq_simulation.QQClient.src.com.zxk.qqcommon;

/**
 * @author: ZHUXIAOKANG
 * @date: 2022/1/26 10:46
 * @description: 表示消息类型
 */
public interface MessageType {
    //1.在接口中定义了一些常量
    //2.不同的常量的值,表示不同的消息类型
    String MESSAGE_LOGIN_SUCCED = "1";//登录成功
    String MESSAGE_LOGIN_FAIL = "2";//登录失败
    String MESSAGE_COMM = "3";//普通消息
    String MESSAGE_GET_ONLINE_FRIEND = "4";//要求返回的在线用户信息
    String MESSAGE_RET_ONLINE_FRIEND = "5";//返回在线用户信息
    String MESSAGE_CLIENT_EXIT = "6";//客户端请求退出
    String MESSAGE_TOALL_MES = "7";//群发消息
    String MESSAGE_TOONE_FILE = "8";//发文件
    String MESSAGE_OFFLINE_MES= "9";//离线消息
}
