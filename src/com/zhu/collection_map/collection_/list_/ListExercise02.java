package com.zhu.collection_map.collection_.list_;


import com.zhu.collection_map.entity.Book;

import java.util.*;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/11/27 18:14
 * @description:
 */
@SuppressWarnings({"all"})
public class ListExercise02 {
    /*

     */
    public static void main(String[] args) {
        //使用arraylist
        ArrayList<Book> arrayList = new ArrayList<>();
        arrayList.add(new Book("金瓶梅","佚名",10));
        arrayList.add(new Book("红楼梦","曹雪芹",11));
        arrayList.add(new Book("西游记","吴承恩",12));
        //冒泡排序
        bubbleSort(arrayList);
        System.out.println("用arraylist");
        for (Book book : arrayList) {
            System.out.println("名称："+book.getName()+"\t\t价格："+book.getPrice()
            +"\t\t作者："+book.getAuthor());
        }
        //用LinkedList
        LinkedList<Book> linkedList = new LinkedList<>();
        linkedList.add(new Book("金瓶梅","佚名",10));
        linkedList.add(new Book("红楼梦","曹雪芹",11));
        linkedList.add(new Book("西游记","吴承恩",12));
        bubbleSort(linkedList);
        System.out.println("用linkedList");
        for (Book book : linkedList) {
            System.out.println("名称："+book.getName()+"\t\t价格："+book.getPrice()
                    +"\t\t作者："+book.getAuthor());
        }
        //用vector
        Vector<Book> vector = new Vector<>();
        vector.add(new Book("金瓶梅","佚名",10));
        vector.add(new Book("红楼梦","曹雪芹",11));
        vector.add(new Book("西游记","吴承恩",12));
        bubbleSort(vector);
        System.out.println("用vector");
        for (Book book : vector) {
            System.out.println("名称："+book.getName()+"\t\t价格："+book.getPrice()
                    +"\t\t作者："+book.getAuthor());
        }

    }

    public static void bubbleSort(List<Book> list){
        Book temp=null;
        for (int i = 0; i < list.size()-1; i++) {
            for (int j=0;j<list.size()-i-1;j++){
                if (list.get(j).getPrice()>list.get(j+1).getPrice()){
                    temp=list.get(j);
                    Book book = list.get(j);
                    book=list.get(j+1);
                    Book book1 = list.get(j + 1);
                    book1=temp;

                    /*
                    另一种做法
                    Book book1 = list.get(j);
                    Book book2 = list.get(j+1);
                    list.set(j, book2);
                    list.set(j + 1, book1);*/
                }
            }
        }
    }
}
