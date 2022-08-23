package com.hspedu.generic.genericexercise2;

import java.util.Comparator;

// MyDate类包含：
// private成员变量month,day,year,并为每一个属性定义getter,setter方法;
public class MyDate implements Comparable<MyDate> {

    private int year;
    private int month;
    private int day;

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return "MyDate{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }

    @Override
    public int compareTo(MyDate o) {    //年月日的比较放这里
        // 如果name相同，比较year
        int yearMinus = year - o.getYear();
        if (yearMinus != 0) {
            return yearMinus;
        }

        // 如果year相同，比较month
        int monthMinus = month - o.getMonth();
        if (monthMinus != 0) {
            return monthMinus;
        }

        // 如果year和month相同
        return day - o.getDay();

    }
}
