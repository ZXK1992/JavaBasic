package com.zhu.reflection_;

/**
 * @author: ZHUXIAOKANG
 * @date: 2022/2/5 14:43
 * @description:
 */
public class Car {
    public String brand="宝马";
    public double price=100000;


    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", price=" + price +
                '}';
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
