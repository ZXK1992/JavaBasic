package com.zhu.oop2.poly_.dynamic_;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/11/5 17:43
 * @description:
 */
public class DynamicBinding {
    public static void main(String[] args) {
//a 的编译类型 A, 运行类型 B
        A a = new B();//向上转型
        /*
        运行类型是B,会找B里面有没有sum方法，如果有就调用，没有则
       调用父类的，又里面有getI()，又会去找B有没有
         */

        System.out.println(a.sum());//?40 -> 30
         /*
        运行类型是B,会找B里面有没有sum方法，如果有就调用，没有则
       调用父类的，里面return i + 10，调用的属性只看编译类型的
         */
        System.out.println(a.sum1());//?30-> 20
    }
}
class A {//父类
    public int i = 10;
    //动态绑定机制:
    public int sum() {//父类 sum()
        return getI() + 10;//20 + 10
    }
    public int sum1() {//父类 sum1()
        return i + 10;//10 + 10
    }
    public int getI() {//父类 getI
        return i;
    }
}
class B extends A {//子类
    public int i = 20;
    // public int sum() {
// return i + 20;
// }
    public int getI() {//子类 getI()
        return i;
    }
// public int sum1() {
// return i + 10;
// }
}