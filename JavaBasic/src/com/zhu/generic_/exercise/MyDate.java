package com.zhu.generic_.exercise;

import java.util.Objects;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/12/15 20:38
 * @description:
 */

public class MyDate implements Comparable<MyDate> {
    private int year;
    private int month;
    private int day;

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }



    @Override
    public String toString() {
        return "MyDate{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Override
    public int compareTo(MyDate o) {
        int minYear = year - o.getYear();
        if (minYear!=0){
            return minYear;
        }
        //1.比较月大小
        int minMonth = month - o.getMonth();
        if (minYear!=0){
            return minMonth;
        }
        //1.比较日大小
        return day- o.getDay();
    }
}