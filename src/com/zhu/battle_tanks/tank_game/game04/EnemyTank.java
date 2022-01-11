package com.zhu.battle_tanks.tank_game.game04;

import java.util.Vector;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/12/19 10:35
 * @description:此类表示敌方坦克 让敌人坦克自己移动，要把它作为线程
 */
@SuppressWarnings({"all"})
public class EnemyTank extends Tank implements Runnable {
    //在敌人坦克类，使用Vector保存多个Shot
    private Vector<Shot> shots = new Vector<>();

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
            //这里我们判断如果shots size()=0,创建一颗子弹，放入到
            //shots集合，并启动
            if (isLive()&&shots.size()<1){//敌人子弹只有一颗的情况，想多颗改数字
                //定义临时变量
                Shot s=null;
                //判断坦克方向，创建对应的子弹
                switch (getDirection()){
                    case 0://上
                        s=new Shot(getX()+20,getY(),0);
                        break;
                    case 1://右
                        s=new Shot(getX()+60,getY()+20,1);
                        break;
                    case 2://下
                        s=new Shot(getX()+20,getY()+60,2);
                        break;
                    case 3://左
                        s=new Shot(getX(),getY()+20,3);
                        break;
                }
                shots.add(s);
                new Thread(s).start();
            }
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
            if (!isLive()) {
                break;//退出线程
            }
        }

    }

}
