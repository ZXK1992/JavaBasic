package com.zhu.oop3.homework.homework05;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/11/15 11:38
 * @description:
 */
public class A {
    private String NAME="ZXK(外)";
    public void useB(){
        /**
         * 局部内部类B
         */
        class B{
            private final String NAME="ZXK(内)";
            public void show(){
                System.out.println(NAME);
                System.out.println(A.this.NAME);
            }

        }
        B b = new B();
        b.show();
    }


}
