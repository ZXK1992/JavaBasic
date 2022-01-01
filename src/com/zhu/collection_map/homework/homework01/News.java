package com.zhu.collection_map.homework.homework01;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/11/27 10:34
 * @description:
 */
public class News {
    private String title;
    private String content;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public News(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "News{" +
                "title='" + title + '\''+
                '}';
    }
}
