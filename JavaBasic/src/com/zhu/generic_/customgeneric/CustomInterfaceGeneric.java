package com.zhu.generic_.customgeneric;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/12/16 16:27
 * @description:
 */
public class CustomInterfaceGeneric {
    public static void main(String[] args) {

    }
}
/**
 * 泛型接口使用的说明
 * 1. 接口中，静态成员也不能使用泛型
 * 2. 泛型接口的类型, 在继承接口或者实现接口时确定
 * 3. 没有指定类型，默认为 Object
 */
interface IUsb<U, R> {
    int n=10;
    //U name;不能这样使用
    //普通方法中可以使用接口泛型
    R getR(U u);

    void hi(R r);

    void run(R r1, R r2, U u1, U u2);

    //在jdk1.8中，可以在接口中，使用默认方法,也是可以使用泛型
    default R method(U u) {
        return null;
    }
}

class C implements IUsb {//等价 class C implements IUsb<Object,Object>
    @Override
    public Object getR(Object o) {
        return null;
    }

    @Override
    public void hi(Object o) {

    }

    @Override
    public void run(Object r1, Object r2, Object u1, Object u2) {

    }
}
//实现接口时，直接指定泛型接口的类型
//给 U 指定 String.md 给 R 指定了 Integer
//所以，当我们实现 IUsb 方法时，会使用 String.md 替换 U, 使用 Integer 替换 R
class A implements IUsb<String, Integer> {
    @Override
    public Integer getR(String s) {
        return null;
    }

    @Override
    public void hi(Integer integer) {

    }

    @Override
    public void run(Integer r1, Integer r2, String u1, String u2) {

    }
}
//在继承接口 指定泛型接口的类型
interface MyInterface extends IUsb<String ,Integer>{}
//当我们去实现 MyInterface 接口时，因为 MyInterface 在继承 IUsb 接口时，指定了 U 为 String.md R 为 Double
//，在实现 IUsb 接口的方法时，使用 String.md 替换 U, 是 Double 替换 R
class D implements MyInterface{
    @Override
    public Integer getR(String s) {
        return null;
    }

    @Override
    public void hi(Integer integer) {

    }

    @Override
    public void run(Integer r1, Integer r2, String u1, String u2) {

    }
}