package com.hspedu.homework.homework05;

public class Homework05 {

    /**
     * 设计父类一员工类。子类：工人类(Worker)，农民类(Peasant)，教师类(Teacher)，科学家类(Scientist)，服务生类(Waiter)。
     * (1) 其中工人，农民，服务生只有基本工资 sal
     * (2) 教师除了基本工资外，还有课酬(元/天) classDay,classSal
     * (3) 科学家除基本工资外，还有年终奖 bonus
     * (4) 编写一个测试类，将各种类型的员工的全年工资打印出来
     */
    public static void main(String[] args) {
        // 工人
        Worker jack = new Worker("jack", 2000);
        jack.setSalMonth(13); // 灵活修改带薪月份
        jack.printSal();

        // 农民
        Peasant smith = new Peasant("smith", 1500);
        smith.printSal();

        // 老师
        Teacher tom = new Teacher("Tom", 3000);
        tom.setClassDay(120);
        tom.setClassSal(100);
        tom.printSal();

        // 科学家
        Scientist pony = new Scientist("pony", 5000);
        pony.setBonus(20000);
        pony.printSal();
    }
}
