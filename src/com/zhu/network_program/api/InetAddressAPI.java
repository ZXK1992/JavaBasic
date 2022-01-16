package com.zhu.network_program.api;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author: ZHUXIAOKANG
 * @date: 2022/1/9 23:11
 * @description:
 */
public class InetAddressAPI {
    public static void main(String[] args) throws UnknownHostException {
        //获取本机InetAddress对象 getLocalHost
        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println(localHost);
        //根据指定主机名/域名获取IP地址对象getByName
        InetAddress byName = InetAddress.getByName("DESKTOP-3QR7NR3");
        System.out.println(byName);
        InetAddress host3 = InetAddress.getByName("www.baidu.com");
        System.out.println(host3);
        //获取InetAddress对象的主机名getHostName
        String hostName = host3.getHostName();
        System.out.println("hostName="+hostName);
        //获取InetAddress对象的地址getHostAddress
        String hostAddress = host3.getHostAddress();
        System.out.println("hostAddress="+hostAddress);
    }
}
