package com.zhu.oop2.homework.homework13;

import java.util.Arrays;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/11/9 10:48
 * @description:
 */
class Homework13 {
    public static void main(String[] args) {
        Student student1 = new Student("小明", '男', 12, "10001");
        Student student2 = new Student("小花", '女', 15, "10002");
        Teacher teacher1 = new Teacher("王老师", '男', 30, 5);
        Teacher teacher2 = new Teacher("朱老师", '男', 29, 5);
        Person[] people = {student1, student2, teacher1, teacher2};
        Person[] people1 = sortArray(people);
        //排序后
        System.out.println("年龄从高到低排序遍历person数组");
        for (Person person : people1) {
            System.out.println(person.printInfo());
            System.out.println("+++++++++++++++++++++++++++++++");
        }

        Person p1 =  new Student("小明", '男', 12, "10011");
        Person p2 =  new Teacher("小明", '男', 40, 10);
        System.out.println();
        m(p1);
        System.out.println("-------------------------------------");
        m(p2);
    }

    public static Person[] sortArray(Person[] people) {
        Person temp;
        for (int i = 0; i < people.length - 1; i++) {
            for (int j = 0; j < people.length - i - 1; j++) {
                if (people[j].getAge() < people[j + 1].getAge()) {
                    temp = people[j];
                    people[j] = people[j + 1];
                    people[j + 1] = temp;

                }
            }
        }
        return people;
    }

    public static void m(Person person) {
        if (person instanceof Student) {
            System.out.println(person.printInfo());
            ((Student) person).study();
        } else if (person instanceof Teacher) {
            System.out.println(person.printInfo());
            ((Teacher) person).teach();
        } else {
            System.out.println("类型异常");
        }
    }
}
