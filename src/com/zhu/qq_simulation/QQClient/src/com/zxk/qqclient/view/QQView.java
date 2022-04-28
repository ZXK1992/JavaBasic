package com.zhu.qq_simulation.QQClient.src.com.zxk.qqclient.view;


import com.zhu.qq_simulation.QQClient.src.com.zxk.qqclient.service.FileClientService;
import com.zhu.qq_simulation.QQClient.src.com.zxk.qqclient.service.MessageClientService;
import com.zhu.qq_simulation.QQClient.src.com.zxk.qqclient.service.UserClientService;
import com.zhu.qq_simulation.QQClient.src.com.zxk.qqclient.utils.Utility;

/**
 * @author: ZHUXIAOKANG
 * @date: 2022/1/26 15:23
 * @description: 客户端菜单界面
 */
public class QQView {

    public static void main(String[] args) {
        new QQView().mainMenu();
        System.out.println("客户端退出系统...");
    }

    private boolean loop = true;
    private String key = "";
    private UserClientService userClientService = new UserClientService();
    private MessageClientService messageClientService = new MessageClientService();//该对象
    private FileClientService fileClientService = new FileClientService();//该对象用于传输文件

    private void mainMenu() {
        while (loop) {
            System.out.println("=============欢迎登录网络通信系统=============");
            System.out.println("\t\t 1 登录系统");
            System.out.println("\t\t 9 退出系统");
            System.out.print("请输入你的选择:");
            key = Utility.readString(1);
            //根据用户输入，来处理不同逻辑
            switch (key) {
                case "1":
                    System.out.print("请输入用户号:");
                    String userId = Utility.readString(50);
                    System.out.print("请输入密  码:");
                    String pwd = Utility.readString(50);
                    //这里比较麻烦,需要到服务端去验证用户是否合法
                    //这里调用Uservice类
                    if (userClientService.checkUser(userId, pwd)) {//还没写完先把逻辑打通
                        //如果验证成功
                        System.out.println("=============欢迎 (用户" + userId + " 登录成功=============");
                        //进入到二级菜单
                        while (loop) {
                            //私聊时知道是谁
                            System.out.println("=============网络通信系统二级菜单(用户" + userId + ")=============");
                            System.out.println("1 显示在线用户列表");
                            System.out.println("2 群发消息");
                            System.out.println("3 私聊消息");
                            System.out.println("4 发送文件");
                            System.out.println("5 离线留言");
                            System.out.println("6 离线发文件");
                            System.out.println("9 退出系统");
                            System.out.print("请输入你的选择:");
                            key = Utility.readString(1);
                            switch (key) {
                                case "1":
                                    userClientService.onlineFriendList();
                                    System.out.println();
                                    break;
                                case "2":
                                    //System.out.println("群发消息");
                                    System.out.println("请输入想对大家说：");
                                    String toAllCont = Utility.readString(100);
                                    messageClientService.sendMessageToAll(toAllCont,userId);
                                    break;
                                case "3":
                                    //System.out.println("私聊消息");
                                    System.out.print("请输入要私聊的用户名(在线)：");
                                    String getterId = Utility.readString(10);
                                    System.out.print("请输入要私聊的信息：");
                                    String content = Utility.readString(100);
                                    messageClientService.sendMessageToOne(content, userId, getterId);
                                    break;
                                case "4":
                                    //System.out.println("发送文件");
                                    System.out.print("请输入想要发文件的用户名(在线)：");
                                    String fileGetId = Utility.readString(10);
                                    System.out.print("请输入发送的文件的完整路径(形式D\\xx.png)：");
                                    String sendPath = Utility.readString(100);
                                    System.out.print("请输入发送文件到对方的路径(形式D\\yy.png)：");
                                    String getPath = Utility.readString(100);
                                    fileClientService.sendFileToOne(userId,fileGetId,sendPath,getPath);
                                    break;
                                case "5":
                                    System.out.print("请输入想要留言的用户：");
                                    String offlineId = Utility.readString(10);
                                    System.out.print("请输入想要留言的消息：");
                                    String offlineContent = Utility.readString(100);
                                    messageClientService.sendOfflineToOne(offlineId,userId,offlineContent);
                                    break;
                                case "9":
                                    loop = false;
                                    userClientService.logout();
                                    break;
                            }
                        }
                    } else {//登录服务器失败
                        System.out.println("=============登录服务器失败=============");
                    }
                    break;
                case "9":
                    loop = false;
                    break;
            }
        }
    }

}


