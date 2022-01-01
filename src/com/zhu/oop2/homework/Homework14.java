package com.zhu.oop2.homework;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/11/9 13:34
 * @description:
 */
public class Homework14 {
    public static void main(String[] args) {
        C c = new C();
    }
}
class A{
   public A(){
       System.out.println("我是A类");
   }
}
class B extends A{
    public B(){
        System.out.println("我是B类无参构造");
    }
    public B(String name){
        System.out.println(name+"我是B类有参构造");
    }
}

class C extends B{
    public C(){
        this("hello");
        System.out.println("我是C类无参构造");
    }
    public C(String name){
        super("hahah");
        System.out.println("我是C类有参构造");
    }
}