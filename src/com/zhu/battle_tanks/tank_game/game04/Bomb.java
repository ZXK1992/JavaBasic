package com.zhu.battle_tanks.tank_game.game04;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/12/31 23:53
 * @description:
 */
public class Bomb {
    private int x;//x坐标
    private int y;//y坐标
    private int life=9;//生命值
    private boolean isLive=true;//存活状态

    //减少生命值
    public void lifeDown(){//配合图片的爆炸效果
        if (life>0){
            life--;
        }else {
            isLive=false;
        }
    }
    public Bomb(int x, int y) {
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

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public boolean isLive() {
        return isLive;
    }

    public void setLive(boolean live) {
        isLive = live;
    }
}
