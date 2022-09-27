package com.hspedu.tankgame05;

import java.util.Vector;

public class EnemyTank extends Tank implements Runnable {

    // 在敌人坦克类，使用Vector 保存多个Shot
    Vector<Shot> shots = new Vector<>();
    // 增加成员，EnemyTank 可以得到敌人坦克的Vector
    // 分析
    // 1.Vector<EnemyTank>
    Vector<EnemyTank> enemyTanks = new Vector<>();

    // 地方坦克是否存活
    boolean isLive = true;

    public EnemyTank(int x, int y) {
        super(x, y);
    }

    // 这里提供一个方法，可以将MyPanel 的成员  Vector<EnemyTank> enemyTanks = new Vector<>();
    // 设置到EnemyTank 的成员 enemyTanks
    public void setEnemyTanks(Vector<EnemyTank> enemyTanks) {
        this.enemyTanks = enemyTanks;
    }

    // 编写方法，判断当前的这个敌人坦克，是否和enemyTanks中的其它坦克发生了重叠或者碰撞
    public boolean isTouchEnemyTank() {
        // 判断当前敌人坦克(this)方向
        switch (this.getDirect()) {
            case 0: //上
                // 让当前敌人坦克和其它所有的敌人坦克比较
                for (int i = 0; i < enemyTanks.size(); i++) {
                    // 从Vector中取出一个敌人坦克
                    EnemyTank enemyTank = enemyTanks.get(i);
                    // 不和自己比较
                    if (enemyTank != this) {
                        // 如果敌人坦克是上/下
                        // 分析
                        // 1.如果敌人坦克是上/下 x的范围[enemyTank.getX(),enemyTank.getX()+40]
                        //                    y的范围[enemyTank.getY(),enemyTank.getY()+60]
                        if (enemyTank.getDirect() == 0 || enemyTank.getDirect() == 2) {
                            // 2.当前坦克 左上角的坐标[this.getX(),this.getY()]

                            // 3. 当前坦克 右上角坐标[this.getX()+40,this.getY()]
                        }
                        // 如果敌人坦克是右/左
                        if (enemyTank.getDirect() == 1 || enemyTank.getDirect() == 3) {
                            /*

                             */
                        }
                    }
                }
            case 1: //右
            case 2: //下
            case 3: //左

        }
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
