package com.hspedu.homework.homework08;

public class SavingsAccount extends BankAccount {

    //分析:
    //(1)新类SavingsAccount每个月都有利息产生(earnMonthlyInterest方法被调用)
    //(2)并且有每月三次免手续费的存款或取款。
    //(3)在earnMonthlyInterest方法中重置交易计数

    // 新增属性
    private int count = 3; // 重置交易计数用
    private double rate = 0.01; // 利率(给一个初始值可动态改变)

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

    // 重写存款方法
    @Override
    public void deposit(double amount) {
        // 判断是否还可以免手续费
        if (count > 0) {
            super.deposit(amount);
        } else {
            super.deposit(amount - 1);
        }
        count--;
    }

    // 重写取款方法

    @Override
    public void withdraw(double amount) {
        if (count > 0) {
            super.withdraw(amount);
        } else {
            super.withdraw(amount + 1);
        }
        count--;
    }

    public void earnMonthlyInterest(){  // 每个月初，我们统计上个月的利息，同时将免手续费重置count=3
        count = 3;
        super.deposit(getBalance() * rate);
    }
}
