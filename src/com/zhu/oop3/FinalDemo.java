package com.zhu.oop3;

/**
 * @author: ZHUXIAOKANG
 * @date: 2022/4/23 23:05
 * @description:
 */
public class FinalDemo {
    public final AA S=new AA();
    public static void main(String[] args) {
        new FinalDemo().S.a=1;
    }
}

class AA{
 public int a;
}
