package com.zhu.collection_map.collection_;

import com.zhu.collection_map.entity.Book;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/11/26 21:26
 * @description:
 */
public class CollectionIterator {
    public static void main(String[] args) {
        Collection col = new ArrayList();
        col.add(new Book("三国演义", "罗贯中", 10.1));
        col.add(new Book("小李飞刀", "古龙", 5.1));
        col.add(new Book("红楼梦", "曹雪芹", 34.6));
        //System.out.println("col="+col);
        //希望遍历col集合
        //1.先得到col对应的迭代器
        Iterator iterator = col.iterator();
        //使用while循环遍历
        while(iterator.hasNext()){//判断是否还有数据
            //返回下一个元素，类型Object
            System.out.println(iterator.next());
        }
        //老师教大家一个快捷键，快速生成 while => itit
        //显示所有的快捷键的的快捷键 ctrl + j
        //3.当退出while循环后，这时Iterator迭代器，指向最后的元素
        //iterator.next();//NoSuchElementException
        //4.如果希望再次遍历，需要重置我们的迭代器
        iterator=col.iterator();
        System.out.println("===第二次遍历");
        while (iterator.hasNext()) {
            Object next = iterator.next();
            System.out.println(next);
        }

    }
}
