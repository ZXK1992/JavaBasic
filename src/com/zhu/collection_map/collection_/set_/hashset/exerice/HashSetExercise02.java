package com.zhu.collection_map.collection_.set_.hashset.exerice;

import java.util.HashSet;
import java.util.Objects;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/10/19 21:22
 * @description:
 */
@SuppressWarnings({"all"})
public class HashSetExercise02 {
    /**
     * 定义一个Employee类，该类包含：private成员属性name,sal,birthday(MyDate类型）
     * ，其中birthday为MyDate类型（属性包括year，month，day),要求：
     * 1.创建3个Employee对象放入Hashset中
     * 2.当name和birthday的值相同时，认为是相同员工，不能添加到hashset集合中
     * */
    public static void main(String[] args) {
        HashSet set = new HashSet();
        set.add(new Employee("zxk",2900,new MyDate(1992,6,24)));
        set.add(new Employee("zxk",3000,new MyDate(1992,6,24)));
        set.add(new Employee("ndy",3500,new MyDate(1993,6,24)));
        System.out.println(set);
    }
}

class Employee{
    private String name;
    private double sal;
    private MyDate brithday;


    public Employee(String name, double sal, MyDate brithday) {
        this.name = name;
        this.sal = sal;
        this.brithday = brithday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }

    public MyDate getBrithday() {
        return brithday;
    }

    public void setBrithday(MyDate brithday) {
        this.brithday = brithday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return name.equals(employee.name) && brithday.equals(employee.brithday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, brithday);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", sal=" + sal +
                ", brithday=" + brithday +
                '}';
    }
}