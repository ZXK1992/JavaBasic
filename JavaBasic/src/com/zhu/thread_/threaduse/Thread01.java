package com.zhu.thread_.threaduse;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/12/19 23:10
 * @description: 演示通过继承 Thread 类创建线程
 */
public class Thread01 {
    /*
    1)请编写程序，开启一个线程，该线程每隔1秒。在控制台输出"喵喵，我是小猫咪”
    2）对上题改进：当输出80次我是小猫咪，结束该线程
    3）使用JConsole监控线程执行情况，并画出程序示意图
     */
    public static void main(String[] args) throws InterruptedException {
        //创建 CatThread 对象，可以当做线程使用
        CatThread catThread = new CatThread();
        //老韩读源码
        /*
        (1)
        public synchronized void start() {
            start0();
        }
        (2)
        //start0() 是本地方法，是 JVM 调用, 底层是 c/c++实现
        //真正实现多线程的效果， 是 start0(), 而不是 run
        private native void start0();
        注意：start()方法调用start0()方法后，该线程并不一定会立马执行，只是将线程变成
             可运行状态，具体什么时候执行，取决于CPU，由CPU统一调度
         */
        catThread.start();;//启动线程-> 最终会执行 catThread 的 run 方法
        //catThread.run();//run 方法就是一个普通的方法, 没有真正的启动一个线程，就会把 run 方法执行完毕，才向下执行
        //说明: 当 main 线程启动一个子线程 Thread-0, 主线程不会阻塞, 会继续执行
        //这时 主线程和子线程是交替执行..
        System.out.println("主线程继续执行" + Thread.currentThread().getName());//名字 main
        for(int i = 0; i < 60; i++) {
            System.out.println("主线程 i=" + i);
        //让主线程休眠
            Thread.sleep(1000);
        }

        //老韩说明
        //1. 当一个类继承了 Thread 类， 该类就可以当做线程使用
        //2. 我们会重写 run 方法，写上自己的业务代码
        //3. run Thread 类 实现了 Runnable 接口的 run 方法
        /*
            @Override
            public void run() {
                if (target != null) {
                    target.run();
                }
            }
        */
    }
}

class CatThread extends Thread{
    int times=0;
    @Override
    public void run() {

        while (true){
            //该线程每隔 1 秒。在控制台输出 “喵喵, 我是小猫咪”
            System.out.println(Thread.currentThread().getName()+"线程输出第"+(++times)+"次：喵喵，我是小猫咪");
            try {
                //本线程休眠一秒
                Thread.sleep(1000);
                //当输出80次我是小猫咪，结束该线程
                if (times==80){//当 times 到 80, 退出 while, 这时线程也就退出..
                    break;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}