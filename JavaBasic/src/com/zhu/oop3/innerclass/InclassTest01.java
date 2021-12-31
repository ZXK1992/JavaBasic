package com.zhu.oop3.innerclass;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/11/19 20:26
 * @description:
 */
public class InclassTest01 {
    public static void main(String[] args) {
        Outer outer = new Outer();
        outer.m1();
    }
}

class Outer{
    private int n1=100;
    public void m1(){
        class Inner{
            private int n1=50;
            public void m2(){
                //如果外部类和局部内部类的成员重名时，默认就近原则，如果想访问外部类的成员
                //      ，则可以使用(外部类名.this.md.成员）去访问
                //Outer.this表示调用m1的外部类对象main方法的outer对象
                System.out.println("内部类的n1="+n1+"外部类的n1="+Outer.this.n1);
            }

        }
        //此处创建对象，外部类只能调用方法
        Inner inner = new Inner();
        inner.m2();
    }
}
