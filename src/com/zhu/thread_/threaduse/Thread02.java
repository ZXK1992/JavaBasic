package com.zhu.thread_.threaduse;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/12/20 10:16
 * @description: 通过实现接口Runnable来开发线程
 */
public class Thread02 {
    public static void main(String[] args) {
       /*
       请编写程序，该程序可以没隔1秒，在控制台输出"hi!"，当输出10次
       后，自动退出。请使用实现Runnable接口的方式实现。这里使用了静
       态代理模式
        */
        OutPrintThread outPrintThread = new OutPrintThread();
        //创建了 Thread 对象，把 dog 对象(实现 Runnable),放入 Thread
        Thread thread = new Thread(outPrintThread);
        thread.start();
    }
}

class OutPrintThread implements Runnable{
    int times=0;
    @Override
    public void run() {
        while (true){
            System.out.println(Thread.currentThread().getName()+"第"+(++times)+"次输出：hi!");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (times==10){
                break;
            }
        }
    }
}
