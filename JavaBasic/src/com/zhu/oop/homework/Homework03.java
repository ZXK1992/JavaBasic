package com.zhu.oop.homework;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/10/5 10:08
 * @description:
 */
public class Homework03 {
    public static void main(String[] args) {
        Book book = new Book();
        book.price=10;
        double updatePrice = book.updatePrice(book);
        System.out.println(updatePrice);
    }
}

/**
 *  编写类Book，定义方法updatePrice，实现更改某本数的价格，具体：
 *  如果价格>150,则更改为150 ，如果价格>100更改为100，否则不变
 */
class Book {
    double price;

    public double updatePrice(Book book) {
        if (book.price > 150) {
            book.price = 150;
        } else if (book.price > 100) {
            book.price = 100;
        }
        return book.price;
    }
}
