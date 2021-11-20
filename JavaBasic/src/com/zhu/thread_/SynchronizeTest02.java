package com.zhu.thread_;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/11/19 17:17
 * @description: 编程模拟三个售票窗口售票100
 * 用Synchronize实现同步方法
 */
public class SynchronizeTest02 {
    public static void main(String[] args) {
        C c = new C();
        new Thread(c).start();
        new Thread(c).start();
        new Thread(c).start();
    }
}
@SuppressWarnings({"all"})
class C implements Runnable {
    //让多个线程共享 ticketNum
    public static int ticketNum = 100;

    public synchronized void synMethod(){
        while (true) {
            if (ticketNum <= 0) {
                System.out.println("售票结束...");
                break;
            }
            //休眠50毫秒
            try {
                Thread.sleep(50);
                System.out.println("当前线程" + Thread.currentThread().getName() +
                        " 售出一张票" + " 剩余票数=" + (--ticketNum));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    @Override
    @SuppressWarnings({"all"})
    public void run() {
        synMethod();
    }
}