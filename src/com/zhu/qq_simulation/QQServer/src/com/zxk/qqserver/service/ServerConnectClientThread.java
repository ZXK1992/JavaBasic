package com.zhu.qq_simulation.QQServer.src.com.zxk.qqserver.service;



import com.zhu.qq_simulation.QQServer.src.com.zxk.qqcommon.Message;
import com.zhu.qq_simulation.QQServer.src.com.zxk.qqcommon.MessageType;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author: ZHUXIAOKANG
 * @date: 2022/1/30 2:06
 * @description: 该类一个对象和某个客户端保持通信
 */
public class ServerConnectClientThread extends Thread {
    private Socket socket;
    private String userId;

    public Socket getSocket() {
        return socket;
    }

    public ServerConnectClientThread(String userId, Socket socket) {
        this.userId = userId;
        this.socket = socket;
    }

    //这里线程处于run状态,可以发送/接收消息
    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("服务器端与客户端" + userId + "保持通信,读取数据...");
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                //读取消息
                Message message = (Message) ois.readObject();
                //后面会使用到message
                //判断message类型
                if (message.getMesType().equals(MessageType.MESSAGE_GET_ONLINE_FRIEND)) {//客户端要求获取在线用户列表
                    //创建新信息包含在线用户列表并返回给客户端
                    //在线用户列表形式，100 200 至尊宝
                    System.out.println(message.getSender() + " 要在线用户列表");
                    Message message2 = new Message();
                    message2.setMesType(MessageType.MESSAGE_RET_ONLINE_FRIEND);
                    // message2.setSender(message.getGetter());
                    message2.setGetter(message.getSender());
                    message2.setContent(ManageClientThreads.getOnlineUser());
                    //返回给客户端
                    ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                    oos.writeObject(message2);
                } else if (message.getMesType().equals(MessageType.MESSAGE_CLIENT_EXIT)) {//客户端退出
                    System.out.println(message.getSender() + "退出");
                    //将这个客户端对应的线程从线程集合移除
                    ManageClientThreads.removeServerConnectClientThread(message.getSender());
                    //关闭socket
                    socket.close();
                    //退出线程
                    break;
                } else if (message.getMesType().equals(MessageType.MESSAGE_COMM)) {//普通私聊消息
                    message.setSendTime(new Date().toString());
                    //根据message获取getterId,然后得到对应线程
                    ServerConnectClientThread serverConnectClientThread = ManageClientThreads
                            .getServerConnectClientThread(message.getGetter());
                    //创建oos对象
                    ObjectOutputStream oos = new ObjectOutputStream(serverConnectClientThread
                            .getSocket().getOutputStream());
                    //提示，如果客户端不在线，可以保存到数据库，这样就可以实现离线留言
                    oos.writeObject(message);
                } else if (message.getMesType().equals(MessageType.MESSAGE_TOALL_MES)) {//群发消息
                    //遍历管理线程集合，把所有线程的socket得到，然后把message转发，排除发送者
                    HashMap<String, ServerConnectClientThread> hm = ManageClientThreads.getHm();
                    Iterator<String> iterator = hm.keySet().iterator();
                    while (iterator.hasNext()) {
                        String userId = iterator.next();
                        if (!userId.equals(message.getSender())) {//排除发送者
                            //转发消息,根据usid获取线程，获取socket，获取输出流
                            ObjectOutputStream oos = new ObjectOutputStream(hm.get(userId).getSocket().getOutputStream());
                            oos.writeObject(message);
                        }
                    }
                } else if (message.getMesType().equals(MessageType.MESSAGE_TOONE_FILE)) {//发文件
                    //拆解mess对象的getid获取该用户通信线程
                    //根据getid获取到对应线程，将message转发
                    ServerConnectClientThread serverConnectClientThread = ManageClientThreads
                            .getServerConnectClientThread(message.getGetter());
                    //获取oos序列化转发消息给指定用户
                    ObjectOutputStream oos = new ObjectOutputStream(serverConnectClientThread.getSocket().getOutputStream());
                    //转发
                    oos.writeObject(message);
                } else if (message.getMesType().equals(MessageType.MESSAGE_OFFLINE_MES)) {//离线留言
                    String getter = message.getGetter();
                    String sender = message.getSender();
                    String content = message.getContent();
                    String sendTime = message.getSendTime();
                    //取出所有在线用户

                    ArrayList<Message> messages = new ArrayList<>();
                    messages.add(message);
                    ConcurrentHashMap<String, ArrayList<Message>> offlineMesHm = QQServer.getOfflineMesHm();
                    offlineMesHm = new ConcurrentHashMap<>();
                    Iterator<String> iterator = ManageClientThreads.getHm().keySet().iterator();
                    while (iterator.hasNext()) {
                        String u = iterator.next();
                        //判断用户是否在线
                        if (!(getter.equals(u)&&u.equals(userId))||!(!getter.equals(u)&&u.equals(userId))) {//不在线
                            offlineMesHm.put(getter, messages);
                            System.out.println(sendTime + "服务器保存离线消息" + content + "成功");
                            Message message1 = new Message();
                            message1.setContent("离线消息保存成功");
                            message1.setSender("服务器");
                            message1.setGetter(sender);
                            ServerConnectClientThread serverConnectClientThread = ManageClientThreads
                                    .getServerConnectClientThread(sender);
                            ObjectOutputStream oos = new ObjectOutputStream(serverConnectClientThread.getSocket().getOutputStream());
                            oos.writeObject(message1);
                        }
                    }
                } else {
                    System.out.println("其他信息暂不处理");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
