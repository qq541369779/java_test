package com.hspedu.shanghai;

import java.util.Scanner;

@SuppressWarnings("all")
public class shanghaijisuan {
    public static void main(String[] args) {

        System.out.println("造成的伤害为：" + formula());
    }

    // 伤害
    public static double formula() {

        double block; // 消除的方块数量
        double restraint; // 克制关系(克制对方+10%伤害，被克制-10%，无克制关系为1)
        double damage; // 暴击伤害，目前默认为1
        double hero; // 英雄自身攻击力
        double monster; // 怪物防御力
        double hero_skill; // 英雄技能系数百分比(百分比的)
        double hero_skill_hurt; // 额外伤害(英雄技能上的固定伤害值)
        double no_skill_bonus; // 基础伤害(没有计算技能的伤害结果)
        double skill_bonus; // 算上技能后的伤害结果

        // 克制关系：红蓝绿黄紫红

        Scanner scanner = new Scanner(System.in);
        System.out.println("消除的方块个数:");
        block = scanner.nextInt();
        System.out.println("克制关系(克制怪物：1，被怪物克制：2，无克制关系：0)");
        restraint = scanner.nextInt();
        System.out.println("暴击伤害(默认情况输入1)：");
        damage = scanner.nextDouble();
        System.out.println("请输入英雄自身属性攻击力：");
        hero = scanner.nextDouble();
        System.out.println("请输入怪物防御力：");
        monster = scanner.nextDouble();
        System.out.println("请输入触发的英雄技能攻击力百分比(省略百分号)：");
        hero_skill = scanner.nextDouble();
        System.out.println("请输入触发的英雄技能固定数值的攻击力：");
        hero_skill_hurt = scanner.nextDouble();

        // 计算消除的方块数量如果小于1 就设置为1
        double num = 0;
        if(block/10 > 1){
            num = block/10;
        }else {
            num = 1;
        }

        // 设置克制关系
        double res = 1; // 默认无克制
        if(restraint == 1){
            res = 0.1;
        }else if(restraint == 2){
            res = -0.1;
        }else {
            res = 1;
        }

        no_skill_bonus = 0.5*(hero-monster) + 0.5*((hero*hero)/(hero+monster));
        skill_bonus = num * res * damage * no_skill_bonus*(hero_skill/100) + hero_skill_hurt;
        System.out.println("英雄造成伤害的计算公式:最终伤害 = 消除个数/10 * 克制关系 * 暴击系数 * 基础伤害 * 技能系数百分比 + 额外伤害");
        System.out.println("消除的方块数量："+block+"\n消除方块基数:"+num+"\n克制关系："+(res*100)+"%"+"\n暴击系数："+damage+"\n基础伤害："+
                no_skill_bonus+"\n技能百分比伤害："+hero_skill+"%"+"\n额外伤害："+hero_skill_hurt);
        return skill_bonus;
    }
}
