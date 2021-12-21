package com.zhu.thread_.method_;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/12/21 14:41
 * @description: 下面我们测试如何将一个线程设置成守护线程
 */
public class ThreadMethod03 {
    public static void main(String[] args) throws InterruptedException {
        MyDaemonThread dt = new MyDaemonThread();
        //将dt设置为守护线程，当所有线程结束后，dt也就自动结束
        //如果没有设置，那么即使main线程执行完成，dt也不退出
        dt.setDaemon(true);
        dt.start();
        for (int i = 1; i <= 100; i++) {
            Thread.sleep(50);
            System.out.println("辛苦工作..."+i);
        }

    }
}

class MyDaemonThread extends Thread{
    @Override
    public void run() {
        for (;;){
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("快乐聊天.....");
        }
    }
}