package com.zhu.battle_tanks.tank_game.game03;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/12/28 17:14
 * @description: 此类表示发射子弹线程类
 */
public class Shot implements Runnable {
    private int x;
    private int y;
    private int direction = 0;
    private int speed = 2;
    private boolean isLive=true;

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

    public Shot(int x, int y, int direction) {
        this.x = x;
        this.y = y;
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

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    @Override
    public void run() {
        while (true) {
            switch (direction) {
                case 0:
                    y -= speed;
                    break;
                case 1:
                    x += speed;
                    break;
                case 2:
                    y += speed;
                    break;
                case 3:
                    x -= speed;
                    break;
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //System.out.println("子弹x="+getX()+"子弹y="+getY());
            if (!(x >= 0 && x < 1000 && y >= 0 && y <= 500)) {
               // System.out.println("发射子弹线程退出");
                isLive=false;
                break;
            }
        }
    }
}

