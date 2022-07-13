package com.hspedu.homework.homework05;

public class Employee { // 父类
    // 属性
    private String name;
    private double sal;
    // 分析：有一个带薪的月份(每个人全年的带薪月份都不同有的12,13,15等)
    private int salMonth = 12;

    // 方法
    //构造器
    public Employee(String name, double sal) {
        this.name = name;
        this.sal = sal;
    }

    // get和set方法
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }

    public int getSalMonth() {
        return salMonth;
    }

    public void setSalMonth(int salMonth) {
        this.salMonth = salMonth;
    }

    // 打印全年工资的方法
    public void printSal() {
        System.out.println(name + "年工资是：" + (sal * salMonth));
    }
}
