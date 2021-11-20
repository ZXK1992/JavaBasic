package com.zhu.oop3.homework.homework06;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/11/15 12:32
 * @description:
 * 有Boat类实现Vehicles
 */
public class Boat implements Vehicles{
    @Override
    public void work() {
        System.out.println("过河的时候使用小船");
    }
}
