package com.zhu.oop2.homework;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/11/7 21:07
 * @description:
 */
public class Homework07 {
}
class Test{
    String name="Rose";
    Test(){
        System.out.println("Test");
    }

     Test(String name) {
        this.name = name;
    }
}

class Demo extends Test{
    String name="Jack";
    Demo(){
        super();
        System.out.println("Demo");
    }
    Demo(String s){
        super(s);
    }

   public void test(){
       System.out.println(super.name);
       System.out.println(this.name);
   }

    public static void main(String[] args) {
        new Demo().test();//匿名对象 Test Demo Rose Jack
        new Demo("john").test();//john Jack
    }
}
