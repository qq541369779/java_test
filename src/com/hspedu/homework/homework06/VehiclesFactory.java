package com.hspedu.homework.homework06;

// 3.创建交通工具工厂类，有两个方法分别获得交通工具Horse和Boat
public class VehiclesFactory {

    // 这里方法使用static可以在编译时就可以直接调用,不使用static使用时需要new一个getHorse对象
    // 整个唐僧取经过程都是使用同一匹马，所以这个每次使用都new一只新马浪费了
    /*public static Boat getHorse(){
     *   return new Boat();
    }*/
    private static Horse horse = new Horse();   // 饿汉式

    // 构造器私有化，不给外部new对象
    private VehiclesFactory() {}

    public static Horse getHorse(){
        return horse;
    }
    // 这里方法使用static可以在编译时就可以直接调用,不使用static使用时需要new一个getBoat对象
    public static Boat getBoat(){
        return new Boat();
    }

    // 获取飞机
    public static Plane getPlane(){
        return new Plane();
    }

}
