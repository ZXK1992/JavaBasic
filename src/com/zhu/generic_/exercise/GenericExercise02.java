package com.zhu.generic_.exercise;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/12/15 20:34
 * @description:
 */
public class GenericExercise02 {
    /**
     * 定义 Employee 类
     * 1) 该类包含：private 成员变量 name,sal,birthday，其中 birthday 为 MyDate 类的对象；
     * 2) 为每一个属性定义 getter, setter 方法；
     * 3) 重写 toString 方法输出 name, sal, birthday
     * 4) MyDate 类包含: private 成员变量 month,day,year；并为每一个属性定义 getter, setter 方法；
     * 5) 创建该类的 3 个对象，并把这些对象放入 ArrayList 集合中（ArrayList 需使用泛型来定义），对集合中的元素进
     行排序，并遍历输出：
     *
     * 排序方式： 调用 ArrayList 的 sort 方法 , * 传入 Comparator 对象[使用泛型]，先按照 name 排序，如果 name 相同，则按生日日期的先后排序。【即：定制排序】
     * 有一定难度 15min , 比较经典 泛型使用案例 GenericExercise02.java
     */
    public static void main(String[] args) {
        //Employee a = null;
        Employee zs = new Employee("zs", 10000, new MyDate(1991, 7, 1));
        Employee ls = new Employee("zs", 11000, new MyDate(1992, 7, 2));
        Employee ww = new Employee("wx", 12000, new MyDate(1994, 3, 3));
        ArrayList<Employee> employees = new ArrayList<>();
        //employees.add(a);
        employees.add(zs);
        employees.add(ls);
        employees.add(ww);
        employees.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                //如果为null或者类型不是Employee
                if(!(o1 instanceof Employee && o2 instanceof Employee)){
                    System.out.println("类型不正确..");
                    return 0;
                }
                //排序姓名
                int i = o1.getName().compareTo(o2.getName());
                if (i!=0){
                    return i;
                }
            /* //排序birthday
               //1.比较年大小
                int minYear = o1.getBirthday().getYear() - o2.getBirthday().getYear();
                if (minYear!=0){
                    return minYear;
                }
                //1.比较月大小
                int minMonth = o1.getBirthday().getMonth() - o2.getBirthday().getMonth();
                if (minYear!=0){
                    return minMonth;
                }
                //1.比较日大小
                return o1.getBirthday().getDay() - o2.getBirthday().getDay();
            */
                //进行优化，Mydate实现Comparable并指定泛型Employee，重写compareTo方法，将上述代码copy
                // implements Comparable<Employee>
                //下面是对 birthday 的比较，因此，我们最好把这个比较，放在 MyDate 类完成
                //封装后，将来可维护性和复用性，就大大增强.
                return o1.getBirthday().compareTo(o2.getBirthday());
            }
        });
       // for (Employee employee : employees) {
            System.out.println(employees);
       // }

    }
}
