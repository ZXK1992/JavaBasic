package com.zhu.oop2.homework;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/10/26 18:15
 * @description:
 */
public class Homework03 {
    public static void main(String[] args) {
        Teacher teacher2 = new Professor("ls", 35, "教授", 7000, 1.3);
        Teacher teacher3 = new AssociateProfessor("ww", 36, "副教授", 6000, 1.2);
        Teacher teacher4 = new Lecturer("ll", 37, "讲师类", 5500, 1.1);
        teacher2.introduce();
        teacher3.introduce();
        teacher4.introduce();
    }
}

/**
 * 编写老师类
 * 1）要求有属性“姓名name”，“年龄age","职称post","基本工资salary"
 * 2)编写业务方法，introduce（），实现输出一个教师的信息
 * 3）编写教师类的三个子类：教授类，副教授类，讲师类。工资级别
 * 分别为：教授为1.3，副教授为1.2，讲师类1.1 。在三个子类里面都重写父类introduce（）
 * 方法。
 * 4）定义并初始化一个老师对象，调用业务方法，实现对象基本信息的后台打印
 */
class Teacher {
    private String name;
    private int age;
    private String post;
    private double salary;
    //级别
    private double grade;

    public Teacher(String name, int age, String post, double salary, double grade) {
        this.name = name;
        this.age = age;
        this.post = post;
        this.salary = salary;
        this.grade = grade;
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

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public void introduce() {
        System.out.println("教师信息：姓名:" + this.getName() + ",年龄:" + this.getAge()
                + ",职称:" + this.getPost() + ",基本工资:" + this.getSalary() + "工资级别" + this.getGrade());
    }
}

/**
 * 教授类
 */
class Professor extends Teacher {
    //特有属性
    public Professor(String name, int age, String post, double salary, double grade) {
        super(name, age, post, salary, grade);
    }

    public void introduce() {
        super.introduce();
    }
}
    /**
     * 副教授类
     */
    class AssociateProfessor extends Teacher {

        public AssociateProfessor(String name, int age, String post, double salary, double grade) {
            super(name, age, post, salary, grade);
        }


        public void introduce() {
            super.introduce();
        }
    }

    /**
     * 讲师类
     */
    class Lecturer extends Teacher {
        public Lecturer(String name, int age, String post, double salary, double grade) {
            super(name, age, post, salary, grade);
        }

        public void introduce() {
            super.introduce();
        }
    }