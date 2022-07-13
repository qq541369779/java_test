package com.hspedu.houserent.view;

import com.hspedu.houserent.domain.House;
import com.hspedu.houserent.service.HouseService;
import com.hspedu.houserent.utils.Utility;

/**
 * 1.显示界面
 * 2.接收用户的输入
 * 3.调用HouseService完成对房屋信息的各种操作
 */

public class HouseView {

    private boolean loop = true; // 控制显示菜单
    private char key = ' '; //接收用户选择
    private HouseService houseService = new HouseService(10); // 设置数组的大小为10

    // 编写listHouses()显示房屋列表
    public void listHouses() {
        System.out.println("==========房屋列表单==========");
        System.out.println("编号\t\t房主\t\t电话\t\t地址\t\t月租\t\t状态(未出租/已出租)");
        House[] houses = houseService.list(); // 得到所有房屋信息
        for (int i = 0; i < houses.length; i++) {
            if (houses[i] == null){ // 如果为null，就不用在显示了
                break;
            }
            System.out.println(houses[i]);
        }
        System.out.println("==========房屋列表显示完毕==========");
    }

    // 显示主菜单
    public void mainMenu() {
        do {
            System.out.println("==========房屋出租系统菜单==========");
            System.out.println("\t\t\t1 新 增 房 源");
            System.out.println("\t\t\t2 查 找 房 源");
            System.out.println("\t\t\t3 删 除 房 屋 信 息");
            System.out.println("\t\t\t4 修 改 房 屋 信 息");
            System.out.println("\t\t\t5 房 屋 列 表");
            System.out.println("\t\t\t6 退      出");
            System.out.println("请输入你的选择(1-6)：");

            key = Utility.readChar();

            switch (key) {
                case '1':
                    System.out.println("新增");
                    break;
                case '2':
                    System.out.println("查找");
                    break;
                case '3':
                    System.out.println("删除");
                    break;
                case '4':
                    System.out.println("修改");
                    break;
                case '5':
                    listHouses();
                    break;
                case '6':
                    System.out.println("退出");
                    loop = false;
                    break;
            }

        } while (loop);
    }
}

