package com.zhu.collection_.hashset;

import java.util.HashSet;
import java.util.Objects;
import java.util.TreeSet;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/10/19 21:22
 * @description:
 */
@SuppressWarnings({"all"})
public class HashSetExercise {
    /**
     * 定义一个Employee类，该类包含：private成员属性name,age要求
     * 1.创建3个Employee对象放入Hashset中
     * 2.当name和age的值相同时，认为是相同员工，不能添加到hashset集合中
     * */
    public static void main(String[] args) {
        HashSet set = new HashSet();
        set.add(new Employee("zxk",29));
        set.add(new Employee("zxk",29));
        set.add(new Employee("zxx",21));
        for (Object o : set) {
            System.out.println(o);
        }
    }
}

class Employee{
    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return age == employee.age && Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}