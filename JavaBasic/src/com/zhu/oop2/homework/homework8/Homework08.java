package com.zhu.oop2.homework.homework8;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/11/7 21:15
 * @description:
 */
public class Homework08 {
    public static void main(String[] args) {
        SavingsAccount savingsAccount = new SavingsAccount(1000);
        savingsAccount.desposit(100);
        savingsAccount.desposit(100);
        savingsAccount.desposit(100);
        System.out.println(savingsAccount.getBalance());
        savingsAccount.desposit(100);
        System.out.println(savingsAccount.getBalance());
        //每个月初定时器调用利息方法
       savingsAccount.earnMonthlyInterest();
        System.out.println(savingsAccount.getBalance());
        savingsAccount.withdraw(100);
        savingsAccount.withdraw(100);
        savingsAccount.withdraw(100);
        savingsAccount.withdraw(100);
        System.out.println(savingsAccount.getBalance());


    }
}

