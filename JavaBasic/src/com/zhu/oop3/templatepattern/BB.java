package com.zhu.oop3.templatepattern;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/11/18 10:32
 * @description:
 */
public class BB extends Template {
    //计算任务
    //1*....* 10000
    @Override
    public void job() {//实现 Template 的抽象方法 job
        long num = 1;
        for (long i = 1; i <= 10000000; i++) {
            num *= i;
        }
    }
}
