package com.zhu.thread_.syn.communication;

/**
 * @author: ZHUXIAOKANG
 * @date: 2022/1/8 0:22
 * @description: 模拟线程通信
 */
public class ThreadCommunicationTest {
    /*
    使用两个线程打印1-100，线程1，线程2交替打印
     */
    public static void main(String[] args) {
        ThreadA threadA = new ThreadA();
        new Thread(threadA, "线程1").start();
        new Thread(threadA, "线程2").start();
    }
}

class ThreadA implements Runnable {
    private int num = 1;

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                notify();
                try {
                    if (num > 100) {
                        break;
                    }
                    System.out.println(Thread.currentThread().getName() + "打印" + (num++));
                    Thread.sleep(100);
                    wait(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}