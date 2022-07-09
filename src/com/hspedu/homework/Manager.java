package com.hspedu.homework;

public class Manager extends Employee {

    // 经理类特有属性 奖金
    private double bonus;

    // 创建Manager对象时，奖金是多少并不是确定的，因此在构造器中不给bonus;
    // 可以通过setBonus
    public Manager(String name, double daySal, int workDays, double grade) {
        super(name, daySal, workDays, grade);
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    // 方法：重写父类的 printSal方法
    @Override
    public void printSal() {
        // 因为经理的工资计算方式和Employee不一样，所以重写
        System.out.println("经理 " + getName() + " 工资=" + (bonus + getDaySal() * getWorkDays() * getGrade()));
    }
}
