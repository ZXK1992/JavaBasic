package com.zhu.thread_.homework.homework01;

import java.util.Scanner;

import static javafx.application.Platform.exit;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/12/22 12:02
 * @description:
 */
public class Homework01 {
    /*
    1)在main方法中启动两个线程
    2）第一个线程循环随机打印100以内的整数
    3）直到第2个线程从键盘读取了"Q"命令
     */
    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        b.setA(a);
        a.start();
        b.start();
    }
}

class A extends Thread {
    private boolean flag = true;

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        while (flag) {
            System.out.println(Thread.currentThread().getName() + "打印" + (int) (Math.random() * 100 + 1));
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("a线程退出");
    }
}

class B extends Thread {
    Scanner scanner = new Scanner(System.in);
    private A a;//通过b线程读取指令后通知a线程，所以b里面需要一个a对象

    public A getA() {
        return a;
    }

    public void setA(A a) {
        this.a = a;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println(Thread.currentThread().getName() + "请输入指令(Q)表示退出：");
            char next = scanner.next().toUpperCase().charAt(0);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            /*if ("Q".equals(next)) {
                a.setFlag(false);//以通知的方式结束a线程
                System.out.println("b线程退出");
                break;
            }*/
            if (next == 'Q') {
                a.setFlag(false);//以通知的方式结束a线程
                System.out.println("b线程退出");
                break;
            }
        }
    }
}