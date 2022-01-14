package com.zhu.battle_tanks.tank_game.game06;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/12/16 22:27
 * @description:坦克父类
 */
public class Tank {
    private int x;
    private int y;
    private int direction;
    private int speed=1;
    //存活状态
    private boolean isLive = true;//是否存活

    public boolean isLive() {
        return isLive;
    }

    public void setLive(boolean live) {
        isLive = live;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public Tank(int x, int y ) {
        this.x = x;
        this.y = y;
    }
public void moveUp(){
        y-=speed;
}
    public void moveRight(){
        x+=speed;
    }
    public void moveDown(){
        y+=speed;
    }
    public void moveLeft(){
        x-=speed;
    }
    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
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
