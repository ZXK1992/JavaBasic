package com.zhu.design_patterns.decorator;

/**
 * @author: ZHUXIAOKANG
 * @date: 2022/1/7 23:00
 * @description:
 */
public class StringRead_ extends Reader_ {
    @Override
    public void read() {
        System.out.println("读取字符串");
    }
}
