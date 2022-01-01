package com.zhu.oop2.homework.homework5;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/11/7 10:53
 * @description:
 */
public class Homework05 {
    public static void main(String[] args) {
        //工人对象
        Worker worker = new Worker("张三", 3000, 12);
        worker.printSalary();
        //农民对象
        Peasant peasant = new Peasant("李四", 2500, 12);
        peasant.printSalary();
//        //老师对象
        Teacher teacher = new Teacher("张老师", 4000, 13);
        teacher.setClassDay(300);
        teacher.setClassSal(1000);
        teacher.printSalary();
        //科学家
        Scientist scientist = new Scientist("朱博士",4000,13);
        scientist.setBonus(100000);
        scientist.printSalary();
        //服务生
        Waiter waiter = new Waiter("王五",3000,12);
        waiter.printSalary();
    }
}
/**
 * 设计父类-——员工类。子类工人类，农民类，教师类，科学家类。
 * 服务生类
 * 1.其中工人，农民，服务生只有基本工资sal
 * 2.教师除基本工资外，还有课酬（元/天）classDay classSal
 * 3.科学家除基本工资外，还有年终奖bonus
 * 4.编写一个测试类，将各种类型的员工的全年工资打印出来
 */

