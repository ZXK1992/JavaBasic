package com.zhu.design_patterns.template;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/11/18 10:32
 * @description:
 */
public class AA extends Template01 {
    //计算任务
    //1+....+ 800000
    @Override
    public void job() {//实现 Template 的抽象方法 job
        long num = 0;
        for (long i = 1; i <= 800000000; i++) {
            num += i;
        }
    }
}
