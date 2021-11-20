package com.zhu.oop3.homework.homework06;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/11/15 12:37
 * @description: 有Person类，有name和Vehicles属性，在构造器中为两个属性赋值
 */
public class Person {
    private String name;
    private Vehicles vehicles;

    //有name和Vehicles属性，在构造器中为两个属性赋值
    //在创建人对象时，事先给他分配一个交通工具
    public Person(String name, Vehicles vehicles) {
        this.name = name;
        this.vehicles = vehicles;
    }

    /*实例化Person对象 唐僧， 要求一般情况下用Horse作为交通工具，遇到
   大河时使用Boat作为交通工具*/
    //这里涉及到一个编程思路，就是可以把上面具体的要求，封装成方法->这里就是编程思想
    //通常情况使用马
    public void common() {
        //if (vehicles == null) {
        //(1)vehicles=null:vehicles instanceof Horse =>false
        //(2)vehicles=船对象:vehicles instanceof Horse =>false
        //(3)vehicles=马对象:vehicles instanceof Horse =>true
        if (!(vehicles instanceof Horse)) {
            vehicles = VehiclesFactory.getHorse();
        }
        vehicles.work();
    }

    //过河用船
    public void passRiver() {
        //if (vehicles == null) {
        //(1)vehicles=null:vehicles instanceof Boat =>false
        //(2)vehicles=马对象:vehicles instanceof Boat =>false
        //(3)vehicles=船对象:vehicles instanceof Boat =>true
        if (!(vehicles instanceof Boat)) {
            vehicles = VehiclesFactory.getBoat();
        }
        vehicles.work();
    }

    //过火焰山
    public void passFireHill() {
        if (!(vehicles instanceof Plane)) {
            vehicles = VehiclesFactory.getPlane();
        }
        vehicles.work();
    }
}
