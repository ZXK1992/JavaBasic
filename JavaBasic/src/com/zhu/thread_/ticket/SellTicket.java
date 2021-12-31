package com.zhu.thread_.ticket;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/12/20 20:18
 * @description: 使用多线程，模拟三个窗口同时售票100张
 */
public class SellTicket {
    public static void main(String[] args) {
        /*
        编程模拟三个售票窗口100，分别使用继承Thread和
        实现Runnable方式
         */
        //继承Thread
   /*     SellTicketT sellTicketT1 = new SellTicketT();
        SellTicketT sellTicketT2 = new SellTicketT();
        SellTicketT sellTicketT3 = new SellTicketT();
        //这里会出现超卖现象
        sellTicketT1.start();//启动售票线程
        sellTicketT2.start();//启动售票线程
        sellTicketT3.start();//启动售票线程
        */
        //实现Runnable方式
        SellTicketTT t1 = new SellTicketTT();
        Thread thread1 = new Thread(t1);
        Thread thread2 = new Thread(t1);
        Thread thread3 = new Thread(t1);
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
class SellTicketT extends Thread {
    //售票你得有总的票数
    public static int ticketCount = 100;//让多个线程共享 ticketNum

    @Override
    public void run() {
        //synchronized (this.md) {
        while (true) {//做一个循环，什么时候卖完就退出
            if (ticketCount <= 0) {//先判断
                System.out.println("售票结束");
                break;
            }
            try {
                //休眠100毫秒，因为卖票肯定是要时间
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //卖出一张票
            System.out.println("窗口"+Thread.currentThread().getName()
                    +"售出一张票,还剩" +(--ticketCount) );//--再输出


        }
        //}
    }
}
class SellTicketTT implements Runnable {
    public static int ticketCount = 100;

    @Override
    public void run() {
        //synchronized (this.md) {
            while (true) {
                if (ticketCount <= 0) {
                    System.out.println("售票结束");
                    break;
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //卖出一张票
                System.out.println(Thread.currentThread().getName()+"售出一张票,还剩" +(--ticketCount) );
            }
        //}
    }
}
