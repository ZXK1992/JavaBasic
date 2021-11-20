package com.zhu.oop3.homework.homework06;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/11/15 12:42
 * @description:
 */
public class Homework06 {
    /*
    1.有一个交通工具接口Vehicles,有work方法
    2.有Horse类和Boat类分别实现Vehicles
    3.创建交通工具工厂类，有两个方法分别获取交通工具Horse和Boat
    4.有Person类，有name和Vehicles属性，在构造器中为两个属性赋值
    5.实例化Person对象 唐僧， 要求一般情况下用Horse作为交通工具，遇到
    大河时使用Boat作为交通工具
    6.使用代码实现上面的要求
    7.增加一个情况，如果唐僧过火焰山，使用飞机 ==>程序扩展性，我们前面的程序
    结构就非常好扩展
     */
    public static void main(String[] args) {
        Person tangSeng = new Person("唐僧", new Horse());
        tangSeng.common();//通常
        tangSeng.passRiver();//过河
        tangSeng.common();//通常
        tangSeng.passFireHill();//过火焰山

    }
}
