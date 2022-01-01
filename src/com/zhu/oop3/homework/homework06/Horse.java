package com.zhu.oop3.homework.homework06;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/11/15 12:32
 * @description:
 * 有Horse类实现Vehicles
 */
public class Horse implements Vehicles{
    @Override
    public void work() {
        System.out.println("一般情况下使用马");
    }
}
