package com.zhu.oop3.homework.homework06;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/11/15 12:34
 * @description:
 * 创建交通工具工厂类，有两个方法分别获取交通工具Horse和Boat
 */
public class VehiclesFactory {
    //因为始终使用的是一匹马，要做成单例模式
    private static Horse horse=new Horse();//饿汉式
    private VehiclesFactory() {
    }
    //获取马
    //这里我们将方法做成static比较方便
    public static Horse getHorse() {
        return horse;
    }
    //获取船
    public static Boat getBoat() {
        return new Boat();
    }

    public static Plane getPlane(){
        return new Plane();
    }
}
