package com.zhu.enum_annotation;


/**
 * @author: ZHUXIAOKANG
 * @date: 2021/10/9 22:58
 * @description:
 */
public class EnumExercise02 {
    public static void main(String[] args) {
        System.out.println("====所有星期的信息如下====");
        for (Week value : Week.values()) {
            System.out.println(value);
        }
    }
}

enum Week{
    MONDAY("星期一"),TUESDAY("星期二"),WEDNESDA("星期三"),THRSDAY("星期四")
    ,FRIDAY("星期五"),SATURDAY("星期六"),SUNDAY("星期日"),;
    private String name;

   private Week(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return  name ;
    }
}