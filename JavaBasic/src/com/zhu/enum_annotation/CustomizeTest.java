package com.zhu.enum_annotation;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/11/20 19:59
 * @description:
 */
public class CustomizeTest {
    public static void main(String[] args) {
        System.out.println(Season.SPRING);
        System.out.println(Season.SUMMER);
        System.out.println(Season.AUTUMN);
        System.out.println(Season.WINTER);
    }
}

//演示字定义枚举实现
class Season {
    private String name;
    private String desc;//描述
    //3. 在 Season 内部，直接创建固定的对象
    //4. 优化，可以加入 final 修饰符
    public final static Season SPRING = new Season("春天", "温暖");
    public final static Season SUMMER = new Season("夏天", "炎热");
    public final static Season AUTUMN = new Season("秋天", "凉爽");
    public final static Season WINTER = new Season("冬天", "寒冷");

    //1. 将构造器私有化,目的防止 直接 new
    private Season(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }
    //2. 去掉 setXxx 方法, 防止属性被修改

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    @Override
    public String toString() {
        return "Season{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
