package com.zhu.thread_.method_;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/12/21 14:19
 * @description:
 */
public class ThreadMethodExercise {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new JoinThreadB());//创建子线程
        for (int i = 1; i <= 10; i++) {
            System.out.println(Thread.currentThread().getName()+"输出hi，第"+i+"次");
            if (i==5){//说明主线程输出了 5 次 hi
                thread.start();//启动子线程 输出 hello...
                thread.join();//立即将 t3 子线程，插入到 main 线程，让 t3 先执行
            }
            Thread.sleep(1000);//输出一次 hi, 让 main 线程也休眠 1s
        }
    }
}

class JoinThreadB implements Runnable{

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println(Thread.currentThread().getName()+"输出hello，第"+i+"次");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}