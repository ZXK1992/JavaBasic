package com.zhu.design_patterns.decorator;

/**
 * @author: ZHUXIAOKANG
 * @date: 2022/1/7 23:06
 * @description:
 */
public class Test_ {
    public static void main(String[] args) {
        //BufferedRead_ bufferedRead_ = new BufferedRead_(new FileRead_());
       BufferedRead_ bufferedRead_ = new BufferedRead_(new StringRead_());
        bufferedRead_.read();
        bufferedRead_.reads(5);
    }
}
