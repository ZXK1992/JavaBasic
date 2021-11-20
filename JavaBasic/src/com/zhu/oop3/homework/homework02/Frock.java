package com.zhu.oop3.homework.homework02;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/11/15 11:03
 * @description:
 */
public class Frock {
    private static int currentNum=100000;//衣服出厂的序列号起始值
    private int serialNumber;//序列号

    public Frock() {
        serialNumber= getNextNum();
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    /**
     * 生成上衣唯一序列号
     * @return
     */
    public static int getNextNum(){
      currentNum+=100;
      return currentNum;
    }
}
