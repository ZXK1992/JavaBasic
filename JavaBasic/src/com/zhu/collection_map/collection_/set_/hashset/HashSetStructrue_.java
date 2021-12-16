package com.zhu.collection_map.collection_.set_.hashset;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/10/17 23:07
 * @description:
 */
public class HashSetStructrue_ {
    public static void main(String[] args) {
        //模拟一个hashset的底层
        //1.创建一个数组 数据类型 Node[]
        //2.有些人直接把 Node[]数组称为表
        Node_[] table = new Node_[16];
        //3.创建结点
        Node_ zhansan = new Node_("zhansan", null);
        table[3]=zhansan;
        Node_ lisi = new Node_("lisi", null);
        zhansan.next=lisi;//将lisi 结点挂载到zhansan
        Node_ wangwu = new Node_("wangwu", null);
        lisi.next=wangwu;//将wangwu结点挂载到lisi
        Node_ lucy = new Node_("lucy", null);
        table[4] = lucy; // 把lucy 放到 table表的索引为3的位置.
        System.out.println("table=" + table);
    }
}
class Node_ {//结点，存储数据，可以指向下一个结点,从而形成链表
    Object item; //存放数据
    Node_ next;//指向下一个
    public Node_(Object item, Node_ next) {
        this.item = item;
        this.next = next;
    }
}