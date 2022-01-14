package com.zhu.battle_tanks.tank_game.game05;

import java.util.Vector;

/**
 * @author: ZHUXIAOKANG
 * @date: 2022/1/13 0:01
 * @description:
 * 该类的一个node对象表示剩余敌人的坦克信息（x,y,方向）
 */
public class Node {
    private int x;
    private int y;
    private int direction;

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

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public Node(int x, int y, int direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }
}
