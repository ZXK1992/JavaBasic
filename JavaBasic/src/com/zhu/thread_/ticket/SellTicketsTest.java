package com.zhu.thread_.ticket;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/11/19 16:52
 * @description: 编程模拟三个售票窗口售票100
 */
public class SellTicketsTest {
    public static void main(String[] args) {
        A a = new A();
        new Thread(a).start();
        new Thread(a).start();
        new Thread(a).start();
    }
}
@SuppressWarnings({"all"})
class A implements Runnable {
    //让多个线程共享 ticketNum
    public static int ticketNum = 100;

    @Override
    public void run() {
        while (true) {
            if (ticketNum <= 0) {
                System.out.println("售票结束...");
                break;
            }
            //休眠1秒
            try {
                Thread.sleep(1000);
                System.out.println("当前线程" + Thread.currentThread().getName() +
                        " 售出一张票" + " 剩余票数=" + (--ticketNum));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

