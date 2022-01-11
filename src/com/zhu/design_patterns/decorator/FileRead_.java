package com.zhu.design_patterns.decorator;

/**
 * @author: ZHUXIAOKANG
 * @date: 2022/1/7 22:57
 * @description:
 */
public class FileRead_ extends Reader_ {
    @Override
    public void read() {
        System.out.println("读取文件内容");
    }
}
