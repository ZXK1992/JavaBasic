package com.zhu.oop3.homework.homework07;

import com.zhu.oop3.homework.homework05.A;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/11/16 18:01
 * @description:
 */
public class Car {
    private double temperature;//温度

    public Car(double temperature) {
        this.temperature = temperature;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    class Air{
        public void flow(){
            if (temperature>40){
                System.out.println("吹冷气");
            }else if (temperature<0){
                System.out.println("吹暖气");
            }else {
                System.out.println("关空调");
            }
        }
    }

    public Air getAir(){
        return new Air();
    }
}
