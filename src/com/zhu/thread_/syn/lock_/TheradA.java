package com.zhu.thread_.syn.lock_;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: ZHUXIAOKANG
 * @date: 2022/1/7 11:35
 * @description: 使用Lock锁模拟线程同步，三个线程卖100张票
 */
public class TheradA implements Runnable {
    private int ticketNum = 100;
    private Lock lock = new ReentrantLock(true);

    @Override
    public void run() {
        while (true) {
            //加锁
            lock.lock();
            try {
                //判断是否够票
                if (ticketNum <= 0) {
                    System.out.println("票已售完");
                    break;
                }
                //休眠100ms
                Thread.sleep(100);
                System.out.println(Thread.currentThread().getName() + "卖出一张票，剩余" + (--ticketNum) + "张");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();

            }

        }
    }
}
