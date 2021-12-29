package com.zhu.design_patterns.proxy;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/12/23 17:33
 * @description: 静态代理模式案例
 */
public class StaticProxyTest {
    public static void main(String[] args) {
        Tiger tiger = new Tiger();
        ThreadProxy threadProxy = new ThreadProxy(tiger);
        threadProxy.start();
    }
}
class Animal {}
class Tiger extends Animal implements Runnable{
    @Override
    public void run() {
        System.out.println("老虎嗷嗷叫...");
    }
}
//线程代理类
class ThreadProxy implements Runnable{
    private Runnable target;

    public ThreadProxy(Runnable target) {
        this.target = target;
    }

    @Override
    public void run() {
        if (target != null) {
            target.run();//会动态绑定Tiger类型
        }
    }

    public void start(){
        start0();
    }

    public void start0() {
        run();
    }
}