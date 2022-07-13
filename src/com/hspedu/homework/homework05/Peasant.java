package com.hspedu.homework.homework05;

public class Peasant extends Employee{

    // 没有特有属性(农民只有基本工资 sal)

    public Peasant(String name, double sal) {
        super(name, sal);
    }

    // 重写父类打印工资方法printSal
    @Override
    public void printSal() {
        System.out.print("农民 ");
        super.printSal();
    }
}
