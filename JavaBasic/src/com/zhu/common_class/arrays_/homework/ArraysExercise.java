package com.zhu.common_class.arrays_.homework;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/11/25 21:14
 * @description:
 */
public class ArraysExercise {
    public static void main(String[] args) {

        Book []books=new Book[4];
        books[0]=new Book("红楼梦",100);
        books[1]=new Book("金瓶梅新",90);
        books[2]=new Book("青年文摘20年",5);
        books[3]=new Book("java从入门到放弃",300);
       //按price从大到小
        Arrays.sort(books, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                double priceVal = o2.getPrice() - o1.getPrice();
                if (priceVal<0){
                    return -1;
                }else if (priceVal>0){
                    return 1;
                }else {
                    return 0;
                }
            }
        });
        System.out.println("按price从大到小:"+Arrays.toString(books));
        //按price从小到大
        Arrays.sort(books, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                double priceVal = o1.getPrice() - o2.getPrice();
                if (priceVal<0){
                    return -1;
                }else if (priceVal>0){
                    return 1;
                }else {
                    return 0;
                }
            }
        });
        System.out.println("按price从小到大:"+Arrays.toString(books));
        //按name长度从大到小
        Arrays.sort(books, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o2.getName().length()-o1.getName().length();
            }
        });
        System.out.println("按name长度从大到小:"+Arrays.toString(books));
    }

}
