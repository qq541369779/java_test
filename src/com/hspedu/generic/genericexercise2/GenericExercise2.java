package com.hspedu.generic.genericexercise2;

import java.util.ArrayList;
import java.util.Comparator;

@SuppressWarnings({"all"})
public class GenericExercise2 {
    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee("tom", 10000, new MyDate(2000, 1, 1)));
        employees.add(new Employee("jack", 20000, new MyDate(2002, 3, 3)));
        employees.add(new Employee("tom", 30000, new MyDate(2004, 5, 5)));

        System.out.println(employees);
        System.out.println("排序后的输出结果");
        // 排序方式：调用ArrayList的sort方法，传入Comparator对象[使用泛型],先按照name排序
        //如果name相同，则按生日日期的先后排序  [定制排序]

        employees.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee emp1, Employee emp2) {
                if (!(emp1 instanceof Employee && emp2 instanceof Employee)) {
                    System.out.println("类型不正确");
                    return 0;
                }
                // 比较name
                int i = emp1.getName().compareTo(emp2.getName());
                if (i != 0) {
                    return i;
                }

                // name相同比较birthday
                // 比较birthday的方法放在MyDate类中进行
                return emp1.getBirthday().compareTo(emp2.getBirthday());

            }
        });
        System.out.println(employees);
    }
}

/*
    定义Employee类
    1.该类包含：private成员变量name,sal,birthday,其中birthday为MyDate类的对象；
    2.为每一个属性定义 getter,setter方法;
    3.重写toString方法输出name,sal,birthday
    4.MyDate类包含：private成员变量month,day,year,并为每一个属性定义getter,setter方法;
    5.创建该类的3个对象，并把这些对象放入ArrayList集合中(ArrayList需使用泛型来定义)，对集合中
    的元素进行排序，并遍历输出

    排序方式：调用ArrayList的sort方法，传入Comparator对象[使用泛型],先按照name排序
    如果name相同，则按生日日期的先后排序  [定制排序]
 */
