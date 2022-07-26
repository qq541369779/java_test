package com.hspedu.list_;

import java.util.ArrayList;
import java.util.List;

public class ListExercise02 {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add(new Book("天龙八部", 25, "龙老师"));
        list.add(new Book("西游记", 20, "孙悟空"));
        list.add(new Book("三国演义", 30, "刘备"));

        // 排序价格从低到高使用冒泡排序
        sort(list);

        for (Object o : list) {
            System.out.println(o);
        }
    }

    // 冒泡排序方法
    public static void sort(List list) {
        int sizeList = list.size();
        for (int i = 0; i < sizeList - 1; i++) {
            for (int j = 0; j < sizeList - 1 - i; j++) {
              // 取出对象Book
                Book book1 = (Book) list.get(j);
                Book book2 = (Book) list.get(j+1);
                if(book1.getPrice() > book2.getPrice()){
                    list.set(j,book2);
                    list.set(j+1,book1);
                }
            }
        }
    }
}


class Book {
    private String name;
    private int price;
    private String author;

    public Book(String name, int price, String author) {
        this.name = name;
        this.price = price;
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "书名：" + name + "\t\t价格：" + price + "\t\t作者：" + author;
    }
}
