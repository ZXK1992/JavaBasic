package com.zhu.generic_.customgeneric;

import java.util.ArrayList;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/12/16 17:11
 * @description:
 * 泛型方法的使用
 */
public class CustomerMethodGeneric {
    public static void main(String[] args) {
        Car car = new Car();
        car.fly("宝马",100);//当调用方法时，传入参数，编译器，就会确定类型
        System.out.println("=======");
        car.fly(300, 100.1);//当调用方法时，传入参数，编译器，就会确定类型

        //测试
//T->String, R-> ArrayList
        Fish<String, ArrayList> fish = new Fish<>();
        fish.hello(new ArrayList(), 11.3f);
    }
}
class Bird<T,R,M>{
    public <E> void fly(E t){
        System.out.println(t);
    }
}

class Fish<T, R> {
    public void run() {//普通方法
    }
    public<U,M> void eat(U u, M m) {//泛型方法
    }
    public <A> A show(A t){
        System.out.println("t的值："+t);
        System.out.println("t的类型："+t.getClass().getSimpleName());
        return t;
    }

    //说明
    //1.下面hi方法不是泛型方法
    //是hi方法使用了类声明的泛型、
    public void hi(T t){}
    //泛型方法，可以使用类声明的泛型，也可以使用自己声明泛型
    public<K> void hello(R r, K k) {
        System.out.println(r.getClass());//ArrayList
        System.out.println(k.getClass());//Float
    }
}

//泛型方法，可以定义在普通类中，也可以定义在泛型类类中
class Car{//普通类
    public void run(){//普通方法

    }
    //说明 泛型方法
    //1.<T,R> 就是泛型
    //2.是提供给fly使用的
    public <T,R> void fly(T t,R r){
        System.out.println(t.getClass());
        System.out.println(r.getClass());
    }

}
