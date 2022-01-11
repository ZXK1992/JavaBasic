package com.zhu.design_patterns.decorator;

/**
 * @author: ZHUXIAOKANG
 * @date: 2022/1/7 23:01
 * @description:
 * 模拟BufferedRead,修饰器设计模式
 */
public class BufferedRead_ extends Reader_ {
    private Reader_ reader_;

    public BufferedRead_(Reader_ reader_) {
        this.reader_ = reader_;
    }

    @Override
    public void read() {
        //这里会动态绑定特定对象的方法
        reader_.read();
    }
    //扩展方法
    //批量读取
    public void reads(int num){
        for (int i = 0; i < num; i++) {
            reader_.read();
        }
    }

  /*  //扩展方法
    //批量读取字符串
    public void readStrings(int num){
        for (int i = 0; i < num; i++) {
            reader_.read();
        }
    }*/
}
