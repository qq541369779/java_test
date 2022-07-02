package com.hspedu.smallchange.oop;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * 该类是完成零钱通的各个功能
 * 使用OOP（面向对象编程）
 * 将各个功能对应一个方法
 */
public class SmallChangeSysOOP {

    // 属性
    // 定义相关的变量
    boolean loop = true;
    Scanner scanner = new Scanner(System.in);
    String key = "";

    // 2.完成零钱通明细
    // 思路，(1)可以把收益入账和消费，保存到数组 (2) 可以使用对象 (3)简单的话可以使用String拼接
    String details = "----------零钱通明细----------";

    //3.完成收益入账  完成功能驱动程序增加新的变量和代码
    //思路，定义新的变量
    double money = 0; //收入的钱
    double balance = 0; //余额
    Date date = null; // 日期
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//日期格式化

    // 4. 消费
    // 定义新变量，保存消费的原因
    String note = "";

    // 先完成显示菜单，并可以选择
    public void mainMenu() {
        do {
            System.out.println("\n==========零钱通菜单（OOP）==========");
            System.out.println("\t\t1 零钱明细");
            System.out.println("\t\t2 收益入账");
            System.out.println("\t\t3 消费");
            System.out.println("\t\t4 退   出");
            System.out.print("请选择（1-4）：");
            key = scanner.next();

            // 使用switch分支控制
            switch (key) {
                case "1":
                    this.detail();
                    break;
                case "2":
                    this.income();
                    break;
                case "3":
                    this.pay();
                    break;
                case "4":
                    this.exit();
                    break;
                default:
                    System.out.println("选择有误，请重新输入");
            }

        } while (loop);

        System.out.println("退出了零钱通项目");
    }

    // 完成零钱通明细
    public void detail() {
        System.out.println(details);
    }

    // 完成收益入账
    public void income() {
        System.out.print("收益入账金额：");
        money = scanner.nextDouble();
        // 校验money的值范围正不正确，-》一会在完善
        //思路：找出不正确的金额条件，然后给出提示，就直接return
        //编程思想，尽量找不正确的条件去判断
        if (money <= 0) {
            System.out.println("收益入账金额需要大于0");
            return; //退出方法，不再执行后面的代码
        }

        balance += money;
        // 拼接收益入账的信息到details
        date = new Date(); // 获取当前日期时间
        details += "\n收益入账\t+" + money + "\t" + sdf.format(date) + "\t" + balance;
    }

    // 消费
    public void pay() {
        System.out.print("消费金额金额：");
        money = scanner.nextDouble();
        // 校验money的值范围正不正确，-》一会在完善
        // 找出金额不正确的情况
        if (money <= 0 || money > balance) {
            System.out.println("你消费的金额 应该在0-" + balance);
            return;
        }
        System.out.print("消费说明:");
        note = scanner.next();
        balance -= money;
        // 拼接消费信息的信息到details
        date = new Date(); // 获取当前日期时间
        details += "\n" + note + "\t-" + money + "\t" + sdf.format(date) + "\t" + balance;
    }

    // 退出
    public void exit() {
        //用户输入4退出时，给出提示”你确定要退出吗？y/n“，必须输入正确的y/n
        //否则循环输入指令，直到输入y或者n
        //思路分析
        // (1)定义一个变量 choice，接收用户的输入
        // (2)使用 while + break,来处理接收到的输入时 y 或者 n
        // (3)退出while后，再判断choice是y还是n，就可以觉得是否退出
        // (4)建议一段代码，完成一个小功能,尽量不要混在一起

        String choice = "";
        while (true) {  // 要求用户必须输入y/n，否则就一直循环
            System.out.println("你确定要退出吗？y/n");
            choice = scanner.next();
            if ("y".equals(choice) || "n".equals(choice)) {
                break;
            }
        }
        // 当用户退出while循环，进行判断1
        if (choice.equals("y")) {
            loop = false;
        }
    }
}
