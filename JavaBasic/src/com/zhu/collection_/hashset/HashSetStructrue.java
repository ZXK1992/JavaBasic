package com.zhu.collection_.hashset;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/10/17 23:07
 * @description:
 */
public class HashSetStructrue {
    public static void main(String[] args) {
        //模拟一个hashset的底层

        //1.创建一个数组 数据类型 Node[]
        //2.有些人直接吧 Node[]数组称为表
        Node[] table = new Node[16];
        //创建结点
    }
}

class Node {//结点，存储数据，可以指向下一个结点
    Object item; //存放数据
    Node next;//指向下一个

    public Node(Object item, Node next) {
        this.item = item;
        this.next = next;
    }
}