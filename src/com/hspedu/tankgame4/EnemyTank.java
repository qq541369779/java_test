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

            /*
                这里我们判断如果shots size() =0，创建一颗子弹，放入
                到shots集合，并启动
             */
            if (isLive && shots.size() < 5) {
                Shot s = null;
                // 判断坦克的方向，创建对应的子弹
                switch (getDirect()) {
                    case 0: // 坦克向上
                        s = new Shot(getX() + 20, getY(), 0);
                        break;
                    case 1: // 坦克向右
                        s = new Shot(getX() + 60, getY() + 20, 1);
                        break;
                    case 2: // 坦克向下
                        s = new Shot(getX() + 20, getY() + 60, 2);
                        break;
                    case 3: // 坦克向左
                        s = new Shot(getX(), getY() + 20, 3);
                        break;
                }
                shots.add(s);
                new Thread(s);
            }


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
