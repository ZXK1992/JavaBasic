package com.zhu.thread_.syn;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/11/19 17:11
 * @description:
 * 编程模拟三个售票窗口售票100
 * 用Synchronize实现同步代码块
 */
public class SynchronizeTest01 {
    public static void main(String[] args) {

        B b = new B();
        new Thread(b).start();
        new Thread(b).start();
        new Thread(b).start();
    }
}
@SuppressWarnings({"all"})
class B implements Runnable {
    //让多个线程共享 ticketNum
    public static int ticketNum = 100;

    @Override
    public void run() {
      synchronized (this) {
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
    }
}