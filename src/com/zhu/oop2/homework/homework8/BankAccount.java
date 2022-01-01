package com.zhu.oop2.homework.homework8;

/**
 * 扩展如下BankAccount类
 */
public class BankAccount {
    private double balance;//余额

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    //存款
    public void desposit(double amount) {
        balance += amount;
    }

    //取款
    public void withdraw(double amount) {
        balance -= amount;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
