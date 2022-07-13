package com.hspedu.houserent.service;

import com.hspedu.houserent.domain.House;

/**
 * HouseService.java<=>类 [业务层]
 * // 定义House[]，保存House对象
 * 1. 响应HouseView的调用
 * 2. 完成对房屋信息的各种操作(增删改查 c[create] r[read] u[update] d[delete])
 */

public class HouseService {

    private House[] houses; //保存House对象

    // 构造器
    public HouseService(int size) {
        houses = new House[size]; // 当创建HouseService对象，指定数组大小
        // 为了配合测试列表信息，这里初始化一个House对象
        houses[0] = new House(1, "jack", "112", "海淀区", 2000, "未出租");
    }

    // list方法，返回houses
    public House[] list() {
        return houses;
    }
}
