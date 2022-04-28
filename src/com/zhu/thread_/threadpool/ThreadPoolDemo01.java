package com.zhu.thread_.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: ZHUXIAOKANG
 * @date: 2022/4/28 13:02
 * @description:
 */
public class ThreadPoolDemo01 {
    public static void main(String[] args) {

        //ExecutorService threadPool = Executors.newSingleThreadExecutor();//单个线程
        //ExecutorService threadPool = Executors.newFixedThreadPool(5);//创建一个固定的线程池大小
        ExecutorService threadPool = Executors.newCachedThreadPool();//可伸缩的，遇强则强，遇弱则弱

        try {
            //new 10个线程
            for (int i = 0; i < 100; i++) {
                //执行线程,使用线程池来创建线程
                threadPool.execute(()->{
                    System.out.println(Thread.currentThread().getName()+"ok");
                });
            }
            //线程池用完后，程序结束要关闭，为保证其关闭放finally
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }

    }
}
