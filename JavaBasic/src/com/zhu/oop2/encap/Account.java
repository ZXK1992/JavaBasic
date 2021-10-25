package com.zhu.oop2.encap;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/10/2 22:44
 * @description:
 */
/*
创建程序
 */
public class Account {
    private String name;
    private double balance;
    private String pwd;

    public Account() {
    }

    public Account(String name, double balance, String pwd) {
        this.setName(name);
        this.setBalance(balance);
        this.setPwd(pwd);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.length() >= 2 && name.length()<= 4) {
            this.name = name;
        } else {
            System.out.println("姓名的长度为2位3位或4位字符，默认值：zxk");
            this.name = "zxk";
        }
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        if (balance > 20) {
            this.balance = balance;
        } else {
            System.out.println("余额必须大于20，默认值100");
            this.balance = 100;
        }
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        if (pwd.length() == 6) {
            this.pwd = pwd;
        } else {
            System.out.println("密码长度必须是六位 ，默认123456");
            this.pwd = "123456";
        }
    }

    @Override
    public String toString() {
        return "Account{" +
                "name='" + name + '\'' +
                ", balance=" + balance +
                ", pwd='" + pwd + '\'' +
                '}';
    }
}
