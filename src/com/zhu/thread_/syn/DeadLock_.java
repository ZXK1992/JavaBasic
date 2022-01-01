package com.zhu.thread_.syn;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/12/22 11:33
 * @description:
 */
public class DeadLock_ {
    public static void main(String[] args) {
        //模拟死锁现象
        DeadLockDemo A = new DeadLockDemo(true);
        A.setName("A线程");
        DeadLockDemo B = new DeadLockDemo(false);
        B.setName("B线程");
        A.start();
        B.start();
    }
}

class DeadLockDemo extends Thread {
    static Object o1 = new Object();// 保证多线程，共享一个对象,这里使用 static
    static Object o2 = new Object();
    boolean flag;

    public DeadLockDemo(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        //下面业务逻辑的分析
        //1.如果flag为T，线程A就会先得到/持有o1对象锁，然后尝试去获取o2对象锁
        //2.如果线程A得不到o2对象锁，就会Blocked
        //3.如果flag为F,线程B就会先得到/持有o2对象锁，然后尝试去获取o1对象锁
        //4.如果线程B得不到o1对象锁，就会Blocked
        if (flag) {
            synchronized (o1) {
                for (int i = 1; i <= 10; i++) {
                    System.out.println(Thread.currentThread().getName()+"hello" + i);

                }
                synchronized (o2) {
                    for (int i = 1; i <= 10; i++) {
                        System.out.println(Thread.currentThread().getName()+"hello2" + i);

                    }
                }
            }

        } else {
            synchronized (o2) {
                for (int i = 1; i <= 10; i++) {
                    System.out.println(Thread.currentThread().getName()+"hi1" + i);

                }
                synchronized (o1) {
                    for (int i = 1; i <= 10; i++) {
                        System.out.println(Thread.currentThread().getName()+"hi2" + i);

                    }
                }

            }

        }
    }
}