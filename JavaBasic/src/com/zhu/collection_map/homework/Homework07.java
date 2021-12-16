package com.zhu.collection_map.homework;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/12/14 17:59
 * @description:
 */
public class Homework07 {
    /*
    试写出Vector和ArrayList的比较
     底层结构：
        ArrayList：可变数组Object[]
        Vector：可变数组Object[]
    出的版本：
        ArrayList：jdk1.2
        Vector：jdk1.0
    线程安全（同步）效率：
        ArrayList：不安全，效率高
        Vector：安全，效率不高
    扩容倍数：
        ArrayList：如果使用有参构造器按照1.5倍扩容，如果是无参构造器
                   第一次扩容10，第二次开始按1.5倍扩容
        Vector：如果是无参构造器，默认10，满后，按照2倍扩容，
                如果是指定大小创建（有参）Vector，则每次按照2倍扩容

     */
}
