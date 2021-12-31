package com.zhu.oop3.homework.homework07;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/11/16 17:53
 * @description:
 */
public class Homework07 {
    /*
    有一个Car类。有属性temperature（温度），车内有Air（空调）类，有吹风的功能flow，
    Air会监视车内的温度，如果温度超过40度则吹冷气，如果温度低于0度则吹暖气，如果在这之间
    则关掉空调。实例化具有不同温度的Car对象，调用空调的flow方法，测试空调吹的风是否正确
    //体现 类与类的包含关系的案例，类（内部类.md[成员内部类）
     */
    public static void main(String[] args) {
        Car car1 = new Car(45);
        Car car2 = new Car(35);
        Car car3 = new Car(-1);
        car1.getAir().flow();
        car2.getAir().flow();
        car3.getAir().flow();
    }
}
