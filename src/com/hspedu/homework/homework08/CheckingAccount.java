package com.hspedu.homework.homework08;

public class CheckingAccount extends BankAccount {

    // 在BankAccount类基础上扩展新类CheckingAccount，对每次存款和取款都收取1美元手续费
    // 重写存款和取款方法

    // 属性
    public CheckingAccount(double initialBalance) {

        super(initialBalance);
    }

    // 存款
    @Override
    public void deposit(double amount) {

        super.deposit(amount - 1);
    }

    // 取款
    @Override
    public void withdraw(double amount) {

        super.withdraw(amount + 1);
    }
}
