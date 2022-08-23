package com.hspedu.event_;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

//KeyListener 是监听器，可以监听键盘事件

public class BallMove extends JFrame {

    MyPanel mp = null;

    public static void main(String[] args) {
        new BallMove();
    }

    public BallMove() {
        mp = new MyPanel();
        this.add(mp);
        this.setSize(500, 500);
        // 窗口JFrame,对象可以监听键盘事件，既可以监听到面板发生的键盘事件
        this.addKeyListener(mp); // 键盘监听事件
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}

class MyPanel extends JPanel implements KeyListener {

    // 为了让小球可以移动，把他的左上角的坐标(x,y)设置变量
    int x = 10;
    int y = 10;

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillOval(x, y, 20, 20);
    }

    // 有字符输出时，该方法就会触发
    @Override
    public void keyTyped(KeyEvent e) {

    }

    // 当某个键按下，该方法会触发
    @Override
    public void keyPressed(KeyEvent e) {

        //System.out.println((char) e.getKeyCode() + "被按下。。");
        //根据用户按下得不同键，来处理小球得移动(上下左右的键)
        if (e.getKeyCode() == KeyEvent.VK_DOWN) { //KeyEvent.VK_DOWN就是向下的箭头对应的code
            y++;
        } else if (e.getKeyCode() == KeyEvent.VK_UP) { //KeyEvent.VK_UP向上箭头对应的code
            y--;
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) { //KeyEvent.VK_LEFT向左箭头对应的code
            x--;
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) { //KeyEvent.VK_RIGHT向右箭头对应的code
            x++;
        }
        // 移动后让面板重绘
        this.repaint();

    }

    // 当某个键释放(松开)，该方法会触发
    @Override
    public void keyReleased(KeyEvent e) {

    }
}
