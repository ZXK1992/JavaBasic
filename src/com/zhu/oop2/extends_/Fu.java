package com.zhu.oop2.extends_;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/11/4 17:27
 * @description:
 */
 public class Fu {
    String name;
    private int age;

    public Fu() {
        System.out.println("父类无参构造器Fu()被调用");
    }

    public Fu(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    private void m() {
    }
    public void callM(){
        m();
    }
}
