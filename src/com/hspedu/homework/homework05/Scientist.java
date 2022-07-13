package com.hspedu.homework.homework05;

public class Scientist extends Employee {

    // 科学家除基本工资外，还有年终奖 bonus
    // 特有属性
    private double bonus;

    public Scientist(String name, double sal) {
        super(name, sal);
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    // 重写父类打印年工资方法
    @Override
    public void printSal() {
        System.out.println(getName() + " 年工资是：" + (getSal() * getSalMonth() + getBonus()));
    }
}
