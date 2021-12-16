package com.zhu.collection_map.collection_.set_.LinkedHashSet;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/12/6 20:25
 * @description:
 */
public class Customer {
    private String name;
    private int no;
    public Customer(String name, int no) {
        this.name=name;
        this.no=no;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", no=" + no +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }
}
