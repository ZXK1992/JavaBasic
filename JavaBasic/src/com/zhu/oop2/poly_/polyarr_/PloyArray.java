package com.zhu.oop2.poly_.polyarr_;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/11/5 17:56
 * @description:
 * 应用实例:现有一个继承结构如下：要求创建 1 个 Person 对象、2 个 Student 对象和 2 个 Teacher 对象, 统一放在数组
 * 中，并调用每个对象
 * say 方法. 应用实例升级：如何调用子类特有的方法，比如
 * Teacher 有一个 teach , Student 有一个 study
 * 怎么调用？
 */
public class PloyArray {
    public static void main(String[] args) {
        Person p = new Person("人", 18);
        Student stu1 = new Student("学生1", 18, 60);
        Student stu2 = new Student("学生2", 19, 61);
        Teacher t1 = new Teacher("老师1", 30, 5000);
        Teacher t2 = new Teacher("老师2", 31, 5000);
        Person[] people = {p, stu1, stu2, t1, t2};
        for (Person person : people) {
            System.out.println(person.say());
            //Teacher 有一个 teach , Student 有一个 study
            // * 怎么调用？
            if (person instanceof Student){
                //向下转型
                ((Student) person).study();
            }else if (person instanceof Teacher){
                ((Teacher) person).teach();
            }
        }
    }
}
