package com.zhu.qq_simulation.QQServer.src.com.zxk.qqserver.service;


import com.zhu.qq_simulation.QQServer.src.com.zxk.qqcommon.Message;
import com.zhu.qq_simulation.QQServer.src.com.zxk.qqcommon.MessageType;
import com.zhu.qq_simulation.QQServer.src.com.zxk.qqcommon.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author: ZHUXIAOKANG
 * @date: 2022/1/29 23:51
 * @description:
 * 这是服务器,在监听9999端口,等待客户端的连接,并保持通信
 */
public class QQServer {
    private ServerSocket ss=null;
    //创建一个集合，存放多个用户，如果这些用户登录，就认为是合法
    //这里我们也可以使用ConcurrentHashMap，可以处理并发的集合，没有线程安全
    //ConcurrentHashMap 处理的线程安全，即线程同步处理，在多线程情况下是安全
    private static ConcurrentHashMap<String, User> validUsers=new ConcurrentHashMap<>();

    public static ConcurrentHashMap<String, ArrayList<Message>> getOfflineMesHm() {
        return offlineMesHm;
    }

    public static void setOfflineMesHm(ConcurrentHashMap<String, ArrayList<Message>> offlineMesHm) {
        QQServer.offlineMesHm = offlineMesHm;
    }

    //存放客户端发送的离线消息
    private static ConcurrentHashMap<String, ArrayList<Message>> offlineMesHm;
    //静态代码块在进行类加载时，会初始化一次
    static {//在静态代码块，初始化validUsers
        validUsers.put("100",new User("100","123456"));
        validUsers.put("200",new User("200","123456"));
        validUsers.put("300",new User("300","123456"));
        validUsers.put("至尊宝",new User("至尊宝","123456"));
        validUsers.put("紫霞仙子",new User("紫霞仙子","123456"));
        validUsers.put("菩提老祖",new User("菩提老祖","123456"));
    }
    //验证用户是否有效的方法
    private boolean checkUser(String userId, String pwd) {
        User user = validUsers.get(userId);
        //过关的验证方式
        if (user==null){//说明userId没有存在validUsers的key中
            return false;
        }
        if (!user.getPwd().equals(pwd)){//userId正确，但是密码错误
            return false;
        }
        return true;
    }
    //服务端启动时就监听,因此放构造器来监听
    public QQServer() {
        //启动推送新闻的线程
        new Thread(new SendNewsToAllService()).start();
        //创建ServerSocket对象
        try {
            //注意,端口可以写在配置文件中
            ss=new ServerSocket(9999);
            System.out.println("服务端在9999端口监听");
            //监听的工作是循环监听的,当和某个客户端建立连接后,会继续监听
            while (true){
                Socket socket = ss.accept();//如果没有客户端连接,就会阻塞在这里
                //用socket读取客户端发的user对象,得到socket关联方对象输入流
                ObjectInputStream ois  = new ObjectInputStream(socket.getInputStream());
                //读取客户端发送过来的user对象
                User u =(User) ois.readObject();
                //验证客户端发送过来的user对象是否合法
                //创建Message对象
                Message message = new Message();
                //创建返回消息给客户端的对象输出流用于回复
                ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                //这里先死后活,固定userid=100,pwd=123456
                if (checkUser(u.getUserId(),u.getPwd())&&ManageClientThreads.getServerConnectClientThread(u.getUserId())==null){//登录通过
                    //给message赋值通过
                    message.setMesType(MessageType.MESSAGE_LOGIN_SUCCED);
                    //将message对象回复客户端
                    oos.writeObject(message);
                    //创建线程和客户端保存通信,该线程持有socket对象
                    ServerConnectClientThread serverConnectClientThread =
                            new ServerConnectClientThread(u.getUserId(), socket);
                    //启动线程
                    serverConnectClientThread.start();
                    //将线程对象放入到集合中,方便管理
                    ManageClientThreads.addServerConnectClientThread(u.getUserId(),serverConnectClientThread);
                }else {//登录不通过,即登录失败
                    System.out.println("用户 id="+u.getUserId()+" pwd="+u.getPwd()+" 验证失败");
                    message.setMesType(MessageType.MESSAGE_LOGIN_FAIL);
                    //将message对象回复客户端
                    oos.writeObject(message);
                    //关闭socket
                    socket.close();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            //如果服务端退出了while,说明服务端不在监听,因此关闭ServerSocket
            try {
                ss.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
