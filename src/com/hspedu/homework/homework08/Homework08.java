package com.hspedu.homework.homework08;

public class Homework08 {
    public static void main(String[] args) {

        // 在BankAccount类基础上扩展新类CheckingAccount，对每次存款和取款都收取1美元手续费

//        CheckingAccount checkingAccount = new CheckingAccount(1000);
//        checkingAccount.deposit(10);// 存入10元，收取1元手续费，实际余额1009
//        System.out.println(checkingAccount.getBalance());
//        checkingAccount.withdraw(9);// 取款9,1099-50-1(取款收取1元手续费)，实际余额999
//        System.out.println(checkingAccount.getBalance());

        // (1)扩展前一个练习的BankAccount类，新类SavingsAccount每个月都有利息产生(earnMonthlyInterest方法被调用)
        // (2)并且有每月三次免手续费的存款或取款。在earnMonthlyInterest方法中重置交易计数
        // (3)体会重写的好处

        SavingsAccount savingsAccount = new SavingsAccount(1000);
        // 存款3次
        savingsAccount.deposit(100);
        savingsAccount.deposit(100);
        savingsAccount.deposit(100);
        // 打印存款余额应该为1300
        System.out.println(savingsAccount.getBalance());
        // 第四次存款需要手续费
        savingsAccount.deposit(100);
        System.out.println(savingsAccount.getBalance()); // 1399

        // 设置定时器每个月初(假设），调用earnMonthlyInterest方法
        savingsAccount.earnMonthlyInterest();
        //重置计数并且计息，利息：1399*0.01=13.99，总余额为1399+13.99=1412.99
        System.out.println(savingsAccount.getBalance());
    }
}
