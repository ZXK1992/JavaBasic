package com.zhu.oop2.homework.homework8;

/**
 * 2.扩展前一个练习的BankAccount类，新类SavingsAccount
 * 每个月都有利息产生
 * （earnMonthlyInterest方法被调用），并且有每月三次
 * 免手续费的存款或取款。在earnMonthlyInterest方法
 * 中重置交易计数
 */
public class SavingsAccount extends BankAccount {
    private int count =3;
    private double rate=0.01;
    @Override
    public void desposit(double amount) {
       //判断是否还可以免手续费
        if (count > 0) {
            super.desposit(amount);
        } else {
            super.desposit(amount-1);
        }
        count--;//减去一次
    }
    @Override
    public void withdraw(double amount) {
        if (count > 0) {
            super.withdraw(amount);
        } else {
           super.withdraw(amount+1);
        }
        count--;
    }

   /**
    * 每个月都有利息产生
    *(earnMonthlyInterest方法被调用），并且有每月三次
    *免手续费的存款或取款。在earnMonthlyInterest方法
    *中重置交易计数
    */
   public void earnMonthlyInterest( ) {
      //每个月初，我们统计上个月的利息，同时将count重置为3
      count=3;
      super.desposit(getBalance()*rate);
    }

    public SavingsAccount(double initialBalance) {
        super(initialBalance);
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }


}