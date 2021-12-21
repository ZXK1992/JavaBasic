package com.zhu.thread_.exit_;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/12/21 10:20
 * @description:
 */
public class ThreadExit_ {
    public static void main(String[] args) {
      //启动一个线程t，要求在main线程中去停止线程t,请编程实现
        EThread eThread = new EThread();
       new Thread(eThread).start();
        for (int i = 1; i <=60; i++) {
            try {
                Thread.sleep(100);//让main线程休眠100毫秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("main运行中"+i);
            if (i==5){
                //中断EThread线程
                eThread.setFlag(false);
            }
        }
    }
}
class EThread implements Runnable{
  private boolean flag=true;//步骤1 定义标记变量，默认为true
    @Override
    public void run() {
        while (flag){//步骤2 将flag作为循环条件

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("EThread运行中");
        }
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}