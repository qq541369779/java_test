package com.hspedu.tankgame4;

import java.util.Vector;

public class EnemyTank extends Tank implements Runnable {

    // 在敌人坦克类，使用Vector 保存多个Shot
    Vector<Shot> shots = new Vector<>();
    // 地方坦克是否存活
    boolean isLive = true;

    public EnemyTank(int x, int y) {
        super(x, y);
    }

    @Override
    public void run() {
        while (true) {
            // 根据坦克的方向来继续移动
            switch (getDirect()) {
                case 0: // 向上
                    for (int i = 0; i < 30; i++) {
                        if (getY() > 0) {
                            moveUp();
                        }
                        // 休眠50毫秒
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 1: // 向右
                    for (int i = 0; i < 30; i++) {
                        if (getX() + 60 < 1000) {
                            moveRight();
                        }
                        // 休眠50毫秒
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 2: // 向下
                    for (int i = 0; i < 30; i++) {
                        if (getY() + 60 < 750) {
                            moveDown();
                        }
                        // 休眠50毫秒
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 3: // 向左
                    for (int i = 0; i < 30; i++) {
                        if (getX() > 0) {
                            moveLeft();
                        }
                        // 休眠50毫秒
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
            }

            // 然后随机的改变坦克方向 0-3
            setDirect((int) (Math.random() * 4));
            // 写并发程序，一定要考虑清楚，该线程什么时候结束
            if (!isLive) {
                break;// 退出线程
            }
        }
    }
}
