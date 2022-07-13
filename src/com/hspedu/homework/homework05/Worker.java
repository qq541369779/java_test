package com.hspedu.homework.homework05;

public class Worker extends Employee{

    // 没有特有属性(工人只有基本工资 sal)
    // 无新增属性直接使用父类构造器
    public Worker(String name, double sal) {
        super(name, sal);
    }

    // 重写父类打印全年工资方法
    @Override
    public void printSal() {
        System.out.print("工人 ");
        super.printSal();
    }
}
