package com.zhu.oop2.homework;

import java.util.Objects;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/11/7 21:59
 * @description:
 */
public class Homework10 {
    public static void main(String[] args) {
        Doctor doctor = new Doctor("张三",30,"眼科",'男',10000);
        Doctor doctor1 = new Doctor("张三",30,"眼科",'男',10000);
        Doctor doctor2 = new Doctor("李四",30,"眼科",'男',10000);
        System.out.println(doctor.equals(doctor1));
        System.out.println(doctor.equals(doctor2));
    }

}
class Doctor{
    private String name;
    private int age;
    private String job;
    private char gender;
    private double sal;

    public Doctor(String name, int age, String job, char gender, double sal) {
        this.name = name;
        this.age = age;
        this.job = job;
        this.gender = gender;
        this.sal = sal;
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

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Doctor doctor = (Doctor) o;
        return age == doctor.age && gender == doctor.gender && Double.compare(doctor.sal, sal) == 0 && Objects.equals(name, doctor.name) && Objects.equals(job, doctor.job);
    }


}