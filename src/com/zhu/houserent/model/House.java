package com.zhu.houserent.model;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/11/11 10:36
 * @description:一个house对象表示一个房屋信息
 */
public class House {
    private int id;//编号
    private String name;//房主姓名
    private String phoneNum;//电话
    private String adderss;//地址
    private double rent;//月租
    private String state;//状态(未出租/已出租)

    public House(int id, String name, String phoneNum, String adderss, double rent, String state) {
        this.id = id;
        this.name = name;
        this.phoneNum = phoneNum;
        this.adderss = adderss;
        this.rent = rent;
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getAdderss() {
        return adderss;
    }

    public void setAdderss(String adderss) {
        this.adderss = adderss;
    }

    public double getRent() {
        return rent;
    }

    public void setRent(double rent) {
        this.rent = rent;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return id +
                "\t\t\t" + name + "\t\t" + phoneNum +
                "\t\t\t"+ adderss  +"\t\t" + rent +
                "\t\t" + state;
    }
}
