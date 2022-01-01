package com.zhu.thread_.threaduse;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/12/20 14:30
 * @description: 多线程执行
 */
public class Thread03 {
    public static void main(String[] args) {
        /*
        请编写一个程序，创建两个线程。一个线程每隔1秒输出"hello,world",输出
        10次，退出，一个线程每隔1秒输出"hi",输出5次退出
         */
        T1 thread1 = new T1();
        T2 t2 = new T2();
        Thread thread2 = new Thread(t2);
        thread1.start();//启动第 1 个线程
        thread2.start();//启动第 2 个线程
    }
}

class T1 extends Thread {
    int times = 0;

    @Override
    public void run() {
        while(true){
            System.out.println(Thread.currentThread().getName() + "输出"
                    + (++times) + "次hello,world");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (times == 10) {
                break;
            }
        }
    }
}

class T2 implements Runnable {
    int times = 0;

    @Override
    public void run() {
        while (true) {
            System.out.println(Thread.currentThread().getName() + "输出"
                    + (++times) + "次hi");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (times == 10) {
                break;
            }
        }
    }
}