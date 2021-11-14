package com.zhu.oop2.poly_;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/11/5 11:24
 * @description:
 */
public class Test {
    public static void main(String[] args) {
        Fu fu = new Zi();//向上转型
        /*
          编译类型看左边，运行类型看右边。
          可以调用父类中的所有成员（需遵守访问权限），
          不能调用子类中的特有成员；
          最终运行效果看子类的具体实现！
         */
        System.out.println(fu.name);
        fu.fuM();
        //向下转型
        Zi zi = new Zi();
        /*
         只能强转父类引用，不能强转父类的对象
        要求父类的引用必须指向的是当前目标类型的对象
        当向下转型后，可以调用子类类型中所有的成员
         */
       // Zi zi = (Zi) fu;
        //zi.ZiM();
        /*
        instanceOf比较操作符，用于判断对象的运行类型是否为XX类型或
          XX类型的子类型
         */
        System.out.println(fu instanceof Fu);
        System.out.println(zi instanceof Fu);
        System.out.println(fu instanceof Zi);
    }
}
