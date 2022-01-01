package com.zhu.thread_.threaduse;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/12/20 14:07
 * @description:
 */
public class ThreadCallable {
    public static void main(String[] args) throws Exception {
        Cat cat = new Cat();
        Runnable r = new FutureTask(cat);
        Thread thread = new Thread(r);
        thread.start();
    }
}

class Cat implements Callable{
    int times;
    @Override
    public Object call() throws Exception {

        while (true){
            System.out.println(Thread.currentThread().getName()+"第"+(++times)+"次喵喵叫");
            Thread.sleep(2000);
            if (times==10){
                break;
            }
        }
        return null;
    }
}