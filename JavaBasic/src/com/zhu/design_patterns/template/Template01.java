package com.zhu.design_patterns.template;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/11/18 10:25
 * @description:抽象类-模板设计模式
 */
public abstract class Template01 {
    //抽象方法
    public abstract void job();
    //实现方法，调用job方法
    public void caculateTime(){
        //得到开始时间
        long start = System.currentTimeMillis();
        job();//动态绑定
        //结束时间
        long end = System.currentTimeMillis();
        System.out.println("执行时间="+(end-start));

    }
}
