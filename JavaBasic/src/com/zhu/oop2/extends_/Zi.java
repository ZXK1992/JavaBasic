package com.zhu.oop2.extends_;


public class Zi extends Fu {

    public Zi() {
     super();
     //this();super（）和this（）都只能放在构造器第一行，因此这两个方法不能共存在一个构造器
        System.out.println("子类无参构造器Zi()被调用");
    }

    public Zi(String name) {
        System.out.println("子类构造器Zi(String name)被调用");

    }

    public Zi(String name, int age) {
        System.out.println("子类构造器Zi(String name, int age)被调用");

    }

    public void zM() {
        getAge();
        callM();
    }
}