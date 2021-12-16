package com.zhu.collection_map.collection_.list_.linkedlist_;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/10/15 11:15
 * @description:
 * 模拟一个简单地双向链表
 */
public class LinkedList01 {
    public static void main(String[] args) {
        //模拟一个简单地双向链表
        Node jack = new Node("jack");
        Node tom = new Node("tom");
        Node zxk = new Node("zxk");
        //连接三个节点，形成双向链表
        //jack->tom->zxk
        jack.next=tom;
        tom.next=zxk;
        //zxk->tom->jack
        zxk.pre=tom;
        tom.pre=jack;

        Node first = jack;//让 first 引用指向 jack,就是双向链表的头结点
        Node last = zxk; //让 last 引用指向 hsp,就是双向链表的尾结点
        //演示，从头到尾进行遍历
        System.out.println("从头到尾进行遍历");
        while (true){
            if(first == null) {
                break;
            }
        //输出 first 信息
            System.out.println(first);
            first = first.next;
        }
        //演示，从尾到头的遍历
        System.out.println("====从尾到头的遍历====");
        while (true){
            if(last == null) {
                break;
            }
            //输出 first 信息
            System.out.println(last);
            last = last.pre;
        }
        //演示链表的添加对象/数据，是多么的方便
        //要求，是在 tom --------- 直接，插入一个对象 smith
        //1. 先创建一个 Node 结点，name 就是 smith
        Node smith = new Node("smith");
        //下面就把 smith 加入到双向链表了
        smith.pre=tom;
        smith.next=zxk;
        zxk.pre=smith;
        tom.next=smith;
        first=jack;
        System.out.println("在 tom --------- 插入一个对象 smith后从头到尾遍历");
        while (true){
            if(first == null) {
                break;
            }
            //输出 first 信息
            System.out.println(first);
            first = first.next;
        }
        //让 last 重新指向最后一个结点
        last=zxk;
        System.out.println("====在 tom ---------zxk之间 插入一个对象 smith后从尾到头的遍历====");
        while (true){
            if(last == null) {
                break;
            }
            //输出 first 信息
            System.out.println(last);
            last = last.pre;
        }
    }
}

//定义一个node 类 ，node
class Node{
    Object item;
    Node next;
    Node pre;

    public Node(Object name) {
        this.item = name;
    }

    @Override
    public String toString() {
        return "Node name=" + item;
    }
}