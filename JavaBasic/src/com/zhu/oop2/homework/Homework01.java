package com.zhu.oop2.homework;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/10/26 0:41
 * @description:
 */
public class Homework01 extends Homework02 {

    public static void main(String[] args) {
        Homework02 homework02 = new Homework02();
        Person p1 = new Person("xm", 2, "javagcs");
        Person p2 = new Person("xw",3,"java");
        Person p3 = new Person("xk",1,"java");
        Person[] persons = {p1,p2,p3};
        Person person = new Person();
        Person[] people = person.bubbleSort(persons);
        for (int i = 0; i < people.length; i++) {
            System.out.println(people[i].toString());
        }
    }
}

/**
 * 定义一个Person类（name，age，job），初始化Person对象数组
 * ，有3个person对象，并按照age从大到小进行排序，提示，使用冒泡排序
 */
class Person {
    private String name;
    private int age;
    private String job;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", job='" + job + '\'' +
                '}';
    }

    public Person[] bubbleSort(Person[] persons) {
        Person p ;
        for (int i = 0; i < persons.length - 1; i++) {
            for (int j = 0; j < persons.length - 1 - i; j++) {
                if (persons[j].age < persons[j + 1].age) {
                    p = persons[j];
                    persons[j] = persons[j + 1];
                    persons[j + 1] = p;
                }
            }
        }
        return persons;
    }

    public Person() {
    }

    public Person(String name, int age, String job) {
        this.name = name;
        this.age = age;
        this.job = job;
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

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }
}
