package com.zhu.battle_tanks.tank_game.game03;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/12/28 17:14
 * @description: 此类表示发射子弹线程类
 */
public class Shot implements Runnable {
    private int x;//子弹x坐标
    private int y;//子弹y坐标
    private int direction = 0;//子弹方向
    private int speed = 2;//子弹的速度
    private boolean isLive=true;//子弹是否还存活，是否可以移动

    public Shot(int x, int y) {
        this.x = x;
        this.y = y;
    }

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
    //射击，改变子弹的坐标
    @Override
    public void run() {
        while (true) {
            //根据方向来改变x,y坐标
            switch (direction) {
                case 0://上
                    y -= speed;
                    break;
                case 1://右
                    x += speed;
                    break;
                case 2://下
                    y += speed;
                    break;
                case 3://左
                    x -= speed;
                    break;
            }
            try {
                //让子弹线程休眠，不然，看不到移动效果
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
             System.out.println("子弹x="+getX()+"子弹y="+getY());
            //当子弹移动到面板的边界时，就应该销毁（把启动的子弹的线程销毁）
            if (!(x >= 0 && x < 1000 && y >= 0 && y <= 500)) {
               // System.md.out.println("发射子弹线程退出");
                isLive=false;
                break;
            }
        }
    }
}

