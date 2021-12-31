package com.zhu.enum_annotation.homework;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/11/15 21:59
 * @description:
 */
public class Homework {
    /*
    枚举类
    1.创建一个Color枚举类
    2.有RED，BLUE，BLACK，YELLOW，GREEN这五个枚举值/对象；
    3.Color有三个属性redValue,  greenValue,  blueValue
    4.创建构造方法，参数包括三个属性
    5.每个枚举值都要给这三个属性赋值，三个属性对应的值分别是
    6.red:255,0,0 blue:0,0,0 yellow:255,255,0 green:0,255,0
    7.定义接口，里面有方法show，要求Color实现该接口
    8.show方法中显示三属性的值
    9.将枚举对象在switch语句中匹配使用
     */
    public static void main(String[] args) {

        Color color = Color.RED;
        //System.md.out.println(color.name());
        switch (color) {
            case RED:
                color.show();
                break;
            case BLUE:
                color.show();
                break;
            case BLACK:
                color.show();
                break;
            case YELLOW:
                color.show();
                break;
            case GREEN:
                color.show();
                break;
            default:
                System.out.println("没匹配到颜色");
                break;

        }
    }
}
