package com.hspedu.homework;

public class Homework04 {
    /**
     * 父类：员工类(Employee)
     * 子类：部门经理类(Manager)，普通员工类(Worker)
     * (1)部门经理工资=1000+单日工资*天数*等级(1.2)。 =>奖金+基本工资
     * (2)普通员工工资=单日工资*天数*等级(1.0)。=>基本工资
     * (3)员工属性:姓名，单日工资，工作天数
     * (4)员工方法(打印工资)
     * (5)普通员工及部门经理都是员工子类,需要重写打印工资方法。
     * (6)定义并初始化普通员工对象，调用打印工资方法输出工资，定义初始化部门经理对象，调用打印工资方法输出工资
     */
    public static void main(String[] args) {
        Manager manager = new Manager("jack", 200, 20, 1.2);
        // 设置经理奖金为3000
        manager.setBonus(3000);
        // 打印经理工资
        manager.printSal();

        // 普通员工
        Worker worker = new Worker("tom",100,20,1.0);
        // 打印普通员工工资
        worker.printSal();
    }
}
