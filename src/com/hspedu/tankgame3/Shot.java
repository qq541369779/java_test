package com.hspedu.tankgame3;


// 子弹射击
public class Shot implements Runnable {

    int x; // 子弹x坐标
    int y; // 子弹y坐标
    int direct = 0; // 子弹方向
    int speed = 2; // 子弹移动速度

    // 构造器
    public Shot(int x, int y, int direct) {
        this.x = x;
        this.y = y;
        this.direct = direct;
    }

    @Override
    public void run() {

    }
}
