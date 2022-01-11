package com.zhu.thread_.threaduse;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/12/20 14:07
 * @description: 创建线程方式三：实现Callable接口。--jdk5.0新增
 */
public class ThreadCallable {
    public static void main(String[] args) throws Exception {
        //3.创建callable实现类的对象cat
        Cat cat = new Cat();
        //4.将cat对象传入FutureTask构造器
        FutureTask<Integer> futureTask = new FutureTask(cat);
        //5.将futureTask对象传入Thread构造器
        Thread thread = new Thread(futureTask);
        thread.start();
        //得到call方法的返回值
        Integer o = futureTask.get();
        System.out.println(o);
    }
}
//1.创建一个实现callable的实现类
class Cat implements Callable<Integer>{
    int times;
    int sum;
    //2.重写call方法
    @Override
    public Integer call() throws Exception {

        while (true){
            System.out.println(Thread.currentThread().getName()+"第"+(++times)+"次喵喵叫");
            Thread.sleep(200);
            sum+=times;
            if (times==10){
                break;
            }
        }
        return sum;
    }
}