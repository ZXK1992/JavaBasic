package com.zhu.oop.encap;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/10/5 21:36
 * @description:
 */
public class AccountTest {
    public static void main(String[] args) {
        Account account = new Account("wbd", 200, "zxkaaa");
        System.out.println(account.toString());
        System.out.println("=================");
        Account account2 = new Account("wbdaaa", 20, "zxkaaaa");
        System.out.println(account2.toString());
    }
}
