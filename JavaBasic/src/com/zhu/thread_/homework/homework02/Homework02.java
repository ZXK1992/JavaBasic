package com.zhu.thread_.homework.homework02;

import sun.rmi.runtime.RuntimeUtil;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/12/22 13:26
 * @description:
 */
public class Homework02 {
    /*
    1)有两个用户分别从同一张卡上取钱（总额10000）
    2）每次都取1000，当余额不足就不能取款了
    3）不能出现超取现象=>线程同步问题
     */
    public static void main(String[] args) {
        Account account = new Account();
        Thread user1 = new Thread(account);
        Thread user2 = new Thread(account);
        user1.start();
        user2.start();
    }
}

//因为这里涉及到多个线程共享资源，所以我们使用实现Runnable方式
class Account implements Runnable {
    static double account = 10000;

    @Override
    public void run() {
        while (true) {
            //1.这里使用synchronized实现了线程同步
            //2.当多个线程执行到这里，就会去争夺this对象锁
            //3.哪个线程争夺到（获取）this对象锁，就执行synchronized代码块，执行完synchronized代码块后，会释放this对象锁
            //4.争夺不到对象锁，就blocked，准备继续争夺
            //5.this对象锁是非公平锁
            synchronized (this) {
                //判断余额是否够
                if (account < 1000) {
                    System.out.println("余额不足");
                    break;
                }
                account -= 1000;
                System.out.println(Thread.currentThread().getName() + "取款1000元，剩余" + account);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}