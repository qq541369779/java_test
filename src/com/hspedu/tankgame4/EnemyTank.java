package com.hspedu.tankgame4;

import java.util.Vector;

public class EnemyTank extends Tank {

    // 在敌人坦克类，使用Vector 保存多个Shot
    Vector<Shot> shots = new Vector<>();

    public EnemyTank(int x, int y) {
        super(x, y);
    }
}