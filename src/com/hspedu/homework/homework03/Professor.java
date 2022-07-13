package com.hspedu.homework.homework03;

public class Professor extends Teacher {
    public Professor(String name, int age, String post, double salary, double grade) {
        super(name, age, post, salary, grade);
    }

    @Override   // 重写父类的introduce方法
    public void introduce() {
        System.out.println("这是教授的信息");
        super.introduce();
    }
}
