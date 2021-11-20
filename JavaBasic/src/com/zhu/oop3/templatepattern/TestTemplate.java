package com.zhu.oop3.templatepattern;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/11/18 10:34
 * @description:
 */
public class TestTemplate {
    /*
     需求：
    1）有多个类，完成不同的任务job
    2)要求能够得到各自完成任务的时间
    3）编程实现
     */
    public static void main(String[] args) {
        AA aa = new AA();
        aa.caculateTime();
        BB bb = new BB();
        bb.caculateTime();
    }
}
