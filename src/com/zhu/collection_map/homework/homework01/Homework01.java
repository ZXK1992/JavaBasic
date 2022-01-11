package com.zhu.collection_map.homework.homework01;

import java.util.ArrayList;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/11/27 10:33
 * @description:
 */
public class Homework01 {
    /*
    按要求实现：
    1）封装一个新闻类，包含标题和内容属性，提供get、set方法，
       重写toString方法，打印对象时只打印标题
    2）只提供一个带参数的构造器，实例化对象时，值初始化标题；并且实例化
       两个对象：
       新闻一：新冠确诊病例超千万，数百万印度教信徒赴恒河"圣浴"引民众担忧
       新闻二：男子突然想起个月前钓的鱼还在往兜里，捞起来一看赶紧放生
    3）将新闻对象添加到ArrayList集合中，并且进行倒序遍历
    4）在遍历集合过程中，对新闻标题进行处理，超过15字的只保留前15个，然后再后边加"..."
    5)在控制台打印遍历出经过处理的新闻标题
     */
    public static void main(String[] args) {
        News news1 = new News("新冠确诊病例超千万，数百万印度教信徒赴恒河 \"圣浴\" 引民众担忧");
        News news2 = new News("男子突然想起个月前钓的鱼还在往兜里，捞起来一看赶紧放生");
        ArrayList<News> newsList = new ArrayList<>();
        newsList.add(news1);
        newsList.add(news2);
        //倒序遍历
        for (int i = newsList.size() - 1; i >= 0; i--) {
            //System.md.out.println(newsList.get(i));
            String title = processTitle(newsList.get(i).getTitle());
            System.out.println(title);
        }

    }

    private static String processTitle(String title) {
        if (title == null) {
            return "";
        }
        if (title.length() > 15) {
            return title.substring(0, 14) + "...";
        } else {
            return title;

        }
    }
}
