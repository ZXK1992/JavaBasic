package com.zhu.thread_.syn.lock_;

import java.io.IOException;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: ZHUXIAOKANG
 * @date: 2022/1/7 23:14
 * @description: 使用Lambda表达式
 * 模拟三个窗口售票
 * Lock锁实现同步
 */
public class LockTest02 {
    public static void main(String[] args) {
        //并发：多线程操作同一个资源类，把资源类丢入线程
        SaleTicket saleTicket = new SaleTicket();
        //Runnable是函数式接口，可以用Lambda表达式
        new Thread(() -> { for (int i = 0; i < 110; i++) saleTicket.sale();},"窗口一").start();
        new Thread(() -> { for (int i = 0; i < 110; i++) saleTicket.sale();},"窗口二").start();
        new Thread(() -> { for (int i = 0; i < 110; i++) saleTicket.sale();},"窗口三").start();
    }
}

//普通的对象类，资源类，解耦
class SaleTicket {
    private int ticketNum = 100;
    private ReentrantLock lock = new ReentrantLock();
    public /*synchronized*/ void sale() {
    /*    if (ticketNum > 0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "卖出一张，剩余" + (--ticketNum) + "张");
        }*/
        lock.lock();
        try {
            if (ticketNum > 0) {
                Thread.sleep(100);
                System.out.println(Thread.currentThread().getName() + "卖出一张，剩余" + (--ticketNum) + "张");
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }


    }
}