package com.zhu.thread_;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/12/20 22:42
 * @description:
 */
public class CPUNum {
    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        //获取当前电脑CPU的数量
        int cpuNums = runtime.availableProcessors();
        System.out.println(cpuNums);
    }
}
