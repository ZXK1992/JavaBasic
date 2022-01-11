package com.zhu.thread_.threaduse;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: ZHUXIAOKANG
 * @date: 2022/1/4 12:20
 * @description:
 */
public class ThreadPool {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.execute(new Dog());
        executorService.shutdown();
    }
}

class Dog implements Runnable{

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("小狗汪汪叫");
        }
    }
}