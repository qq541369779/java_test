package com.hspedu.tankgame2;

import javax.swing.*;

public class HspTankGame02 extends JFrame {

    //定义MyPanel
    MyPanel mp = null;

    public static void main(String[] args) {

        new HspTankGame02();
    }

    public HspTankGame02(){

        MyPanel mp = new MyPanel();
        this.add(mp);  //添加面板(就是游戏的绘图区域)
        this.setSize(1000,750);
        this.addKeyListener(mp); // 让JFrame 监听mp的键盘事件
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
