package com.zhu.collection_map.collection_.set_.treeset;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/12/13 21:24
 * @description:
 */
public class TreeSet_ {
    public static void main(String[] args) {
/*
        1.当我们使用无参构造器，创建TreeSet时，仍然是无序的
        2.如果希望添加的元素，按照字符串大小来排序
        3.使用TreeSet提供的一个构造器，可以传入一个比较器（匿名内部类）
        并指定排序规则
        4.简单看看原码
            1. 构造器把传入的比较器对象，赋给了 TreeSet 的底层的 TreeMap 的属性 this.md.comparator
                public TreeMap(Comparator<? super K> comparator) {
                    this.md.comparator = comparator;
                }
            2. 在 调用 treeSet.add("tom"), 在底层会执行到
                if (cpr != null) {//cpr 就是我们的匿名内部类(对象)
                    do {
                        parent = t;
                        //动态绑定到我们的匿名内部类(对象)compare
                        cmp = cpr.compare(key, t.key);
                        if (cmp < 0)
                        t = t.left;
                        else if (cmp > 0)
                        t = t.right;
                        else //如果相等，即返回 0,这个 Key 就没有加入
                        return t.setValue(value);
                    } while (t != null);
                }
*/
        // TreeSet treeSet = new TreeSet();
        TreeSet treeSet = new TreeSet(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                //下面 调用 String.md 的 compareTo 方法进行字符串大小比较
                //如果老韩要求加入的元素，按照长度大小排序
                //return ((String.md) o2).compareTo((String.md) o1);
                return ((String) o1).length() - ((String) o2).length();
            }
        });
        //添加数据.
        treeSet.add("jack");
        treeSet.add("tom");//3
        treeSet.add("sp");
        treeSet.add("a");
        treeSet.add("abc");//3
        System.out.println("treeSet=" + treeSet);

    }
}
