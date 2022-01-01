package com.zhu.thread_.method_;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/12/21 13:32
 * @description:
 */
public class ThreadMethod02 {
    public static void main(String[] args) throws InterruptedException {
        /*
        main线程创建一个子线程，每隔1s输出hello，输出20次，主线程每隔一秒输出hi
        ,输出20次，要求：两个线程同时执行，当主线程输出5次后，就让子线程运行完毕，主线程再继续
         */
        ThreadJoin threadJoin = new ThreadJoin();
        Thread thread = new Thread(threadJoin);
        thread.start();
        for (int i = 1; i <= 20; i++) {
            System.out.println(Thread.currentThread().getName() + "输出hi,第" + i + "次");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (i == 5) {
                thread.join();
            }
        }
    }
}

class ThreadJoin implements Runnable {

    @Override
    public void run() {
        for (int i = 1; i <= 20; i++) {
            System.out.println(Thread.currentThread().getName() + "输出hello，第" + i + "次");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
