package com.zhu.oop2.homework.homework8;

/*
要求 1. 在上面类的基础上扩展新类CheckingAccount
对每次存款和取款都收取1美元的手续费
2.扩展前一个练习的BankAccount类，新类SavingsAccount
每个月都有利息产生
（earnMonthlyInterest方法被调用），并且有每月三次
免手续费的存款或取款。在earnMonthlyInterest方法
中重置交易计数
3.体会重写的好处
 */
public class CheckingAccount extends BankAccount {

    public CheckingAccount(double initialBalance) {
        super(initialBalance);
    }

    //存款
    public void desposit(double amount) {
       super.desposit(amount-1);
    }

    //取款
    public void withdraw(double amount) {
        super.desposit(amount + 1);
    }
}
