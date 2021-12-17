package com.zhu.battle_tanks.tank_game;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/12/16 22:27
 * @description:坦克父类
 */
public class Tank {
    private int x;
    private int y;

    public Tank(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
