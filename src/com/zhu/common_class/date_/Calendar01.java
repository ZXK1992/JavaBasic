package com.zhu.common_class.date_;

import java.util.Calendar;
import java.util.Date;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/11/26 12:19
 * @description:
 */
public class Calendar01 {
    /*
    1)第二代日期类，主要就是Calendar类(日历)
     public abstract class Calendar extends Object
     implements Serializable, Cloneable, Comparable<Calendar> {}
     2)Calendar类是一个抽象类，他为特定瞬间与一组诸如YEAR、MONTH、
     DAY_OF_MONTH、HOUR等日历字段之间的转换提供了一些方法，并为操作
     日历字段（例如获取下星期的日期）提供了一些方法
     */
    public static void main(String[] args) {
        //1. Calendar 是一个抽象类， 并且构造器是 private
        //2. 可以通过 getInstance() 来获取实例
        //3. 提供大量的方法和字段提供给程序员
        //4. Calendar 没有提供对应的格式化的类，因此需要程序员自己组合来输出(灵活)
        //5. 如果我们需要按照 24 小时进制来获取时间， Calendar.HOUR ==改成=> Calendar.HOUR_OF_DAY
        Calendar c = Calendar.getInstance(); //创建日历类对象//比较简单，自由
        System.out.println("c=" + c);
        //2.获取日历对象的某个日历字段
        System.out.println("年：" + c.get(Calendar.YEAR));
        // 这里为什么要 + 1, 因为 Calendar 返回月时候，是按照 0 开始编号
        System.out.println("月：" + (c.get(Calendar.MONTH) + 1));
        System.out.println("日：" + c.get(Calendar.DAY_OF_MONTH));
        System.out.println("小时：" + c.get(Calendar.HOUR));
        System.out.println("分钟：" + c.get(Calendar.MINUTE));
        System.out.println("秒：" + c.get(Calendar.SECOND));
        //Calender 没有专门的格式化方法，所以需要程序员自己来组合显示
        System.out.println(c.get(Calendar.YEAR) + "-" + (c.get(Calendar.MONTH) + 1) + "-" +
                c.get(Calendar.DAY_OF_MONTH) +
                " " + c.get(Calendar.HOUR_OF_DAY) + ":" + c.get(Calendar.MINUTE) + ":" + c.get(Calendar.SECOND));

    }
}
