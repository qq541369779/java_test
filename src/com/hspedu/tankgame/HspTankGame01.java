package com.hspedu.tankgame;

import com.hspedu.generic.genericexercise2.MyDate;

import javax.swing.*;

public class HspTankGame01 extends JFrame {

    //定义MyPanel
    MyPanel mp = null;

    public static void main(String[] args) {

        new HspTankGame01();
    }

    public HspTankGame01(){

        MyPanel mp = new MyPanel();
        this.add(mp);  //添加面板(就是游戏的绘图区域)
        this.setSize(1000,750);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
