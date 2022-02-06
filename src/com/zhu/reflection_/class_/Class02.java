package com.zhu.reflection_.class_;

import com.zhu.reflection_.Car;

import java.lang.reflect.Field;

/**
 * @author: ZHUXIAOKANG
 * @date: 2022/2/5 13:30
 * @description:
 */
public class Class02 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException {
        String classAllPath="com.zhu.reflection_.Car";
        //1.获取到Car类对应的Class对象
        //<?> 表示不确定的 Java 类型
        Class <?> cls = Class.forName(classAllPath);
        //2.输出cls
        System.out.println(cls);///显示 cls 对象, 是哪个类的 Class 对象 com.zhu.reflection_.Car
        System.out.println(cls.getClass());//输出 cls 运行类型 java.lang.Class
        //3.得到包名
        System.out.println(cls.getPackage().getName());
        //4.得到全类名
        System.out.println(cls.getName());
        //5.通过cls创建对象实例
        Car car = (Car)cls.newInstance();
        System.out.println(car);//car.toString()
        //6.通过反射获取属性brand,此方法只能得到public的
        Field brand = cls.getField("brand");
        System.out.println(brand.get(car));//宝马
        //7.通过反射给属性赋值
        brand.set(car,"奔驰");
        System.out.println(brand.get(car));//奔驰
        //8.我希望可以得到所有的属性
        System.out.println("所有的字段属性");
        Field[] fields = cls.getFields();
        for (Field field : fields) {
            System.out.println(field.getName());//名称
        }
    }
}
