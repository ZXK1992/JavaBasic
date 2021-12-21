package com.zhu.thread_.method_;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/12/21 11:01
 * @description:
 */
public class ThreadMethod01 {
    public static void main(String[] args) throws InterruptedException {
    //main 方法
    //方式一：
        ThreadDemo1 td = new ThreadDemo1();
        td.setName("小笼包");
        td.setPriority(Thread.MIN_PRIORITY);
        td.start();
        //测试优先级
        System.out.println("默认优先级="+Thread.currentThread().getPriority());
        //测试interrupt
        Thread.sleep(3000);
        td.interrupt();
    }
}
class ThreadDemo1 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName()+"吃包子``"+i);
        }
        try {
            System.out.println(Thread.currentThread().getName()+"休眠中");
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            //当该线程执行到一个interrupt方法时，就会catch一个异常，可以加入自己的业务代码
            System.out.println(Thread.currentThread().getName()+"被interrupt了");
        }

    }
}