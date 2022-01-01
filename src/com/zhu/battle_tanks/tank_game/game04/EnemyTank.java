package com.zhu.battle_tanks.tank_game.game04;

import java.util.Vector;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/12/19 10:35
 * @description:此类表示敌方坦克 让敌人坦克自己移动，要把它作为线程
 */
public class EnemyTank extends Tank implements Runnable {
    //在敌人坦克类，使用Vector保存多个Shot
    private Vector<Shot> shots = new Vector<>();
    private boolean isLive = true;//是否存活

    public boolean isLive() {
        return isLive;
    }

    public void setLive(boolean live) {
        isLive = live;
    }

    public EnemyTank(int x, int y) {
        super(x, y);
    }

    public Vector<Shot> getShots() {
        return shots;
    }

    public void setShots(Vector<Shot> shots) {
        this.shots = shots;
    }

    @Override
    public void run() {
        while (true) {
            //根据坦克方向来继续移动
            switch (getDirection()) {
                case 0://向上
                    //让坦克保持一个方向移动，走30步
                    for (int i = 0; i < 30; i++) {
                        if (getY() > 0) {
                            moveUp();
                        }
                        //休眠100ms
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 1://向右
                    for (int i = 0; i < 30; i++) {
                        if ((getX() + 60) < 1000) {
                            moveRight();
                        }
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 2://向下
                    for (int i = 0; i < 30; i++) {
                        if ((getY() + 60) < 600) {
                            moveDown();
                        }
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 3://向左
                    for (int i = 0; i < 30; i++) {
                        if (getX() > 0) {
                            moveLeft();
                        }
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
            }
            //然后随机的改变方向，0-3
            setDirection((int) (Math.random() * 4));
            //System.out.println("坦克x=" + getX() + "坦克y=" + getY());
            //线程结束,一旦写并发程序，一定要考虑清楚，该线程什么时候退出
            if (!isLive) {
                break;//退出线程
            }
        }

    }

}
