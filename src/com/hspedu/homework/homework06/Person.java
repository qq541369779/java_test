package com.hspedu.homework.homework06;

// 4.有Person类，有name和Vehicles属性，在构造器中为两个属性赋值
public class Person {
    private String name;
    private Vehicles vehicles;

    // 在创建人对象时，事先给他分配一个交通工具
    public Person(String name, Vehicles vehicles) {
        this.name = name;
        this.vehicles = vehicles;
    }

    //5.实例化Person对象“唐僧”,要求一般情况下用Horse作为交通工具，遇到大河时用Boat作为交通工具
    //思考：如何不浪费，在构建对象(Homework06.java中 new Person是分配的马儿对象),传入的交通工具对象
    // 过河
    public void passRiver(){
        // 先得到船
        //判断一下，当前的 vehicles 属性是null，就获取一艘船
        // 如何防止始终使用的是传入的马儿，instanceof
        // if(vehicles == null)
        // vehicles instanceof Boat 是判断 当前 vehicles是不是Boat
        //(1)vehicles = null ：vehicles instanceof Boat =>是假
        //(2)vehicles = 马对象 ：vehicles instanceof Boat =>是假
        //(3)vehicles = 船对象 ：vehicles instanceof Boat =>是真
        if(!(vehicles instanceof Boat)){
            vehicles = VehiclesFactory.getBoat();
        }
        vehicles.work();
    }

    // 一般情况
    public void common(){
        // 得到马儿
        //判断一下，当前的 vehicles 属性是null，就获取一匹马
       // if(vehicles == null){//向上转型
        if(!(vehicles instanceof Horse)){
            // vehicles 等于传进来的交通工具对象
            // 使用的是多态
            vehicles = VehiclesFactory.getHorse();
        };
        // 这里体现使用接口调用(接口解耦特性)
        vehicles.work();
    }

    // 过火焰山
    public void mountain(){
        if(!(vehicles instanceof Plane)){
            vehicles = VehiclesFactory.getPlane();
        }
        vehicles.work();
    }

}
