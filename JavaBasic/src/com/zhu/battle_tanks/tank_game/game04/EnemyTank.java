package com.zhu.battle_tanks.tank_game.game04;

import java.util.Vector;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/12/19 10:35
 * @description:此类表示敌方坦克
 */
public class EnemyTank extends Tank {
    //在敌人坦克类，使用Vector保存多个Shot
    private Vector<Shot> shots=new Vector<>();
    public EnemyTank(int x, int y) {
        super(x, y);
    }

    public Vector<Shot> getShots() {
        return shots;
    }

    public void setShots(Vector<Shot> shots) {
        this.shots = shots;
    }

}
