package com.zhu.qq_simulation.QQServer.src.com.zxk.qqcommon;

import java.io.Serializable;

/**
 * @author: ZHUXIAOKANG
 * @date: 2022/1/26 10:19
 * @description: 表示客户端和服务端通信时的消息对象
 */
public class Message implements Serializable {
    private final static long serialVersionUID=1L;
    private String sender;//发送者
    private String getter;//获取者
    private String content;//消息内容
    private String sendTime;//发送时间
    private String mesType;//消息类型[可以在接口定义消息类型]
    private byte[] bytes;//消息类型[可以在接口定义消息类型]

    public int getFileLen() {
        return fileLen;
    }

    public void setFileLen(int fileLen) {
        this.fileLen = fileLen;
    }

    public String getDest() {
        return dest;
    }

    public void setDest(String dest) {
        this.dest = dest;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    private int fileLen=0;//文件大小
    private String dest;//将文件传输到哪里
    private String src;//源文件路径
    public byte[] getBytes() {
        return bytes;
    }

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getGetter() {
        return getter;
    }

    public void setGetter(String getter) {
        this.getter = getter;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }

    public String getMesType() {
        return mesType;
    }

    public void setMesType(String mesType) {
        this.mesType = mesType;
    }
}
