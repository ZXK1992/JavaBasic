package com.zhu.thread_.syn;

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
    private static boolean loop1 = true;
    private boolean loop = true;

    //老韩说明
//1. public synchronized void synMethod() {} 就是一个同步方法
//2. 这时锁在 this 对象
//3. 也可以在代码块上写 synchronize ,同步代码块, 互斥锁还是在 this 对象
/*    public synchronized void synMethod(){  //同步方法, 在同一时刻， 只能有一个线程来执行 synMethod 方法
            if (ticketNum <= 0) {
                System.out.println("售票结束...");
                loop=false;
                return;
            }
            //休眠50毫秒
            try {
                Thread.sleep(50);
                System.out.println("当前线程" + Thread.currentThread().getName() +
                        " 售出一张票" + " 剩余票数=" + (--ticketNum));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    }*/

    //同步方法（静态的）的锁为当前类本身C.class
/*    public static synchronized void synSMethod() {
        if (ticketNum <= 0) {
            System.out.println("售票结束...");
            loop1 = false;
            return;
        }
        //休眠50毫秒
        try {
            Thread.sleep(50);
            System.out.println("当前线程" + Thread.currentThread().getName() +
                    " 售出一张票" + " 剩余票数=" + (--ticketNum));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }*/

      public static void synStaicMethod(){
          //如果静态方法中，实现一个同步代码块，锁为当前类本身C.class

            while (true) {
            synchronized (C.class){
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
    @Override
    @SuppressWarnings({"all"})
    public void run() {
       // while (loop) {
            synStaicMethod();
       // }
    }
}