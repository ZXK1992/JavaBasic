package com.zhu.collection_map.map;

import java.util.*;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/12/8 9:41
 * @description:
 */
public class MapExercise {
    /*
    使用HashMap添加3个员工对象要求
    键：员工id
    值；；员工对象
    并遍历显示工资>18000的员工（遍历方式最少两种）
    员工类：姓名、工资、员工id

     */
    public static void main(String[] args) {
        HashMap hashMap = new HashMap();
        hashMap.put(1,new Employee("zhangsan",2000,1));
        hashMap.put(2,new Employee("zhangsan",19999,2));
        hashMap.put(3,new Employee("zhangsan",20000,3));
        Set set = hashMap.keySet();
        Iterator iterator = set.iterator();
        System.out.println("keyset的迭代器");
        while (iterator.hasNext()) {
            Object next = iterator.next();
            if (((Employee)hashMap.get(next)).getSal()>18000){
                System.out.println(hashMap.get(next));
            }
        }
        System.out.println("keyset的增强for");
        for (Object o : set) {
            if (((Employee)hashMap.get(o)).getSal()>18000)
                System.out.println(hashMap.get(o));
        }

        //values
        Collection values = hashMap.values();
        System.out.println("values的增强for");
        for (Object value : values) {
            if (((Employee)value).getSal()>18000){
                System.out.println(value);
            }
        }
        //entryset
        Set set1 = hashMap.entrySet();
        System.out.println("entryset的增强for");
        for (Object o : set1) {
            if (((Employee)(((Map.Entry)o).getValue())).getSal()>18000){
                System.out.println(((Map.Entry)o).getValue());
            }
        }

    }
}
class Employee{
    private String name;
    private double sal;
    private int id;

    public Employee(String name, double sal, int id) {
        this.name = name;
        this.sal = sal;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", sal=" + sal +
                ", id=" + id +
                '}';
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}