package com.zhu.thread_.syn.lock_;

/**
 * @author: ZHUXIAOKANG
 * @date: 2022/1/7 11:34
 * @description:
 */
public class LockTest {
    public static void main(String[] args) {
        TheradA theradA = new TheradA();
        Thread t1 = new Thread(theradA);
        t1.setName("窗口一");
        Thread t2 = new Thread(theradA);
        t2.setName("窗口二");
        Thread t3 = new Thread(theradA);
        t3.setName("窗口三");
        t1.start();
        t2.start();
        t3.start();
    }
}
