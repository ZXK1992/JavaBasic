package com.zhu.oop3.innerclass;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/11/19 21:36
 * @description:外部其它类访问成员内部类
 */
public class InnerclassTest02 {
    //外部其它类访问成员内部类的方式
    public static void main(String[] args) {
        //第一种new 外部类对象，外部类对象.new内部类对象
        Outer02 outer02 = new Outer02();
        Outer02.Inner02 inner02 = outer02.new Inner02();
        inner02.m1();
        System.out.println("------------------");
        //第二种在外部类的成员位置编写一个getter方法
        Outer02.Inner02 inner02Instance = outer02.getInner02Instance();
        inner02Instance.m1();
    }
}

class Outer02{
    private int n1=100;
   public class Inner02{
       private int n1=10;
       public void m1(){
           System.out.println("外部类的n1"+Outer02.this.n1+",内部类的n1"+n1);
       }
   }
    private void m1(){
        System.out.println("外部类的m1()");
    }
    public Inner02 getInner02Instance(){
       return new Inner02();
    }
}
