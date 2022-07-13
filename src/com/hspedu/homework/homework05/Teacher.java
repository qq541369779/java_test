package com.hspedu.homework.homework05;

public class Teacher extends Employee {

    // 教师除了基本工资外，还有课酬(元/天) classDay,classSal
    // 特有属性
    private int classDay;
    private double classSal;

    public Teacher(String name, double sal) {
        super(name, sal);
    }

    public int getClassDay() {
        return classDay;
    }

    public void setClassDay(int classDay) {
        this.classDay = classDay;
    }

    public double getClassSal() {
        return classSal;
    }

    public void setClassSal(double classSal) {
        this.classSal = classSal;
    }

    // 重写父类打印全年工资方法

    @Override
    public void printSal() { // 父类的super.printSal()方法无法使用，因为新增了两个特有属性
        System.out.println(getName() + " 年工资是：" + (getSal() * getSalMonth() + classSal * classDay));
    }
}
