package com.zhu.battle_tanks.tank_game.game05;

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

    private Vector<EnemyTank> enemyTankVector = new Vector<>();

    public EnemyTank(int x, int y) {
        super(x, y);
    }

    public Vector<Shot> getShots() {
        return shots;
    }

    public void setShots(Vector<Shot> shots) {
        this.shots = shots;
    }

    public Vector<EnemyTank> getEnemyTankVector() {
        return enemyTankVector;
    }

    public void setEnemyTankVector(Vector<EnemyTank> enemyTankVector) {
        this.enemyTankVector = enemyTankVector;
    }

    @Override
    public void run() {
        while (true) {
            //这里我们判断如果shots size()=0,创建一颗子弹，放入到
            //shots集合，并启动
            if (isLive() && shots.size() < 1) {//敌人子弹只有一颗的情况，想多颗改数字
                //定义临时变量
                Shot s = null;
                //判断坦克方向，创建对应的子弹
                switch (getDirection()) {
                    case 0://上
                        s = new Shot(getX() + 20, getY(), 0);
                        break;
                    case 1://右
                        s = new Shot(getX() + 60, getY() + 20, 1);
                        break;
                    case 2://下
                        s = new Shot(getX() + 20, getY() + 60, 2);
                        break;
                    case 3://左
                        s = new Shot(getX(), getY() + 20, 3);
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
                        //y>0,并且没有和别的坦克碰撞
                        // overlapTank(enemyTankVector)返回发生碰撞为true
                        if (getY() > 0 && !isTouchEnemyTank()) {
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
                        if ((getX() + 60) < 1000 && !isTouchEnemyTank()) {
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
                        if ((getY() + 60) < 600 && !isTouchEnemyTank()) {
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
                        if (getX() > 0 && !isTouchEnemyTank()) {
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

    /**
     * 敌方坦克重叠判断
     */
    public boolean isTouchEnemyTank() {
        switch (this.getDirection()) {
            case 0://当前目标坦克向上
                //遍历坦克集合enemyTankVector判断
                for (int i = 0; i < enemyTankVector.size(); i++) {
                    //排除坦克集合enemyTankVector中的自己
                    EnemyTank enemyTank = enemyTankVector.get(i);
                    if (this != enemyTank) {
                        //根据其他坦克方向判断
                        //其他坦克上下方向
                        if (enemyTank.getDirection() == 0 || enemyTank.getDirection() == 2) {
                            //当前目标坦克的左上角坐标(this.getX(),this.getY())
                            //比较的坦克x范围[enemyTank.getX(),enemyTank.getX()+40]
                            //比较的坦克y范围[enemyTank.getY(),enemyTank.getY()+60]
                            if (this.getX() > enemyTank.getX()
                                    && this.getX() < enemyTank.getX() + 40
                                    && this.getY() > enemyTank.getY()
                                    && this.getY() < enemyTank.getY() + 60) {
                                return true;
                            }
                            //当前目标坦克的右上角坐标(this.getX() + 40,this.getY())
                            //比较的坦克x范围[this.getX(),this.getX()+40]
                            //比较的坦克y范围[enemyTank.getY(),enemyTank.getY()+60]
                            if (this.getX() + 40 > enemyTank.getX()
                                    && this.getX() + 40 < enemyTank.getX() + 40
                                    && this.getY() > enemyTank.getY()
                                    && this.getY() < enemyTank.getY() + 60) {
                                return true;
                            }
                        }
                        //其他坦克左右方向
                        if (enemyTank.getDirection() == 1 || enemyTank.getDirection() == 3) {
                            //当前目标坦克的左上角坐标(this.getX(),this.getY())
                            //比较的坦克x范围[this.getX(),this.getX()+60]
                            //比较的坦克y范围[enemyTank.getY(),enemyTank.getY()+40]
                            if (this.getX() > enemyTank.getX()
                                    && this.getX() < enemyTank.getX() + 60
                                    && this.getY() > enemyTank.getY()
                                    && this.getY() < enemyTank.getY() + 40) {
                                return true;
                            }
                            //当前目标坦克的右上角坐标(this.getX() + 40,this.getY())
                            //比较的坦克x范围[this.getX(),this.getX()+60]
                            //比较的坦克y范围[enemyTank.getY(),enemyTank.getY()+40]
                            if (this.getX() + 40 > enemyTank.getX()
                                    && this.getX() + 40 < enemyTank.getX() + 60
                                    && this.getY() > enemyTank.getY()
                                    && this.getY() < enemyTank.getY() + 40) {
                                return true;
                            }
                        }
                    }
                }
                break;
            case 1://当前目标坦克向右
                //遍历坦克集合enemyTankVector判断
                for (int i = 0; i < enemyTankVector.size(); i++) {
                    //排除坦克集合enemyTankVector中的自己
                    EnemyTank enemyTank = enemyTankVector.get(i);
                    if (this != enemyTank) {
                        //根据其他坦克方向判断
                        //其他坦克上下方向
                        if (enemyTank.getDirection() == 0 || enemyTank.getDirection() == 2) { //当前目标坦克的右上角坐标(this.getX()+60,this.getY())
                            //比较的坦克x范围[enemyTank.getX(),enemyTank.getX()+40]
                            //比较的坦克y范围[enemyTank.getY(),enemyTank.getY()+60]
                            if (this.getX() + 60 > enemyTank.getX()
                                    && this.getX() + 60 < enemyTank.getX() + 40
                                    && this.getY() > enemyTank.getY()
                                    && this.getY() < enemyTank.getY() + 60) {
                                return true;
                            }
                            //当前目标坦克的右下角坐标(this.getX() + 60,this.getY()+40)
                            //比较的坦克x范围[enemyTank.getX(),enemyTank.getX()+40]
                            //比较的坦克y范围[enemyTank.getY(),enemyTank.getY()+60]
                            if (this.getX() + 60 > enemyTank.getX()
                                    && this.getX() + 60 < enemyTank.getX() + 40
                                    && this.getY() + 40 > enemyTank.getY()
                                    && this.getY() + 40 < enemyTank.getY() + 60) {
                                return true;
                            }
                        }
                        //其他坦克左右方向
                        if (enemyTank.getDirection() == 1 || enemyTank.getDirection() == 3) {
                            //当前目标坦克的右上角坐标(this.getX()+60,this.getY())
                            //比较的坦克x范围[enemyTank.getX(),enemyTank.getX()+60]
                            //比较的坦克y范围[enemyTank.getY(),enemyTank.getY()+40]
                            if (this.getX() + 60 > enemyTank.getX()
                                    && this.getX() + 60 < enemyTank.getX() + 60
                                    && this.getY() > enemyTank.getY()
                                    && this.getY() < enemyTank.getY() + 40) {
                                return true;
                            }
                            //当前目标坦克的右下角坐标(this.getX() + 60,this.getY()+40)
                            //比较的坦克x范围[enemyTank.getX(),enemyTank.getX()+60]
                            //比较的坦克y范围[enemyTank.getY(),enemyTank.getY()+40]
                            if (this.getX() + 60 > enemyTank.getX()
                                    && this.getX() + 60 < enemyTank.getX() + 60
                                    && this.getY() + 40 > enemyTank.getY()
                                    && this.getY() + 40 < enemyTank.getY() + 40) {
                                return true;
                            }
                        }
                    }
                }
                break;
            case 2://当前目标坦克向下
                //遍历坦克集合enemyTankVector判断
                for (int i = 0; i < enemyTankVector.size(); i++) {
                    //排除坦克集合enemyTankVector中的自己
                    EnemyTank enemyTank = enemyTankVector.get(i);
                    if (this != enemyTank) {
                        //根据其他坦克方向判断
                        //其他坦克上下方向
                        if (enemyTank.getDirection() == 0 || enemyTank.getDirection() == 2) {
                            //当前目标坦克的左下角坐标(this.getX(),this.getY()+60)
                            //比较的坦克x范围[enemyTank.getX(),enemyTank.getX()+40]
                            //比较的坦克y范围[enemyTank.getY(),enemyTank.getY()+60]
                            if (this.getX() > enemyTank.getX()
                                    && this.getX() < enemyTank.getX() + 40
                                    && this.getY() + 60 > enemyTank.getY()
                                    && this.getY() + 60 < enemyTank.getY() + 60) {
                                return true;
                            }
                            //当前目标坦克的右下角坐标(this.getX() + 40,this.getY()+60)
                            //比较的坦克x范围[enemyTank.getX(),enemyTank.getX()+40]
                            //比较的坦克y范围[enemyTank.getY(),enemyTank.getY()+60]
                            if (this.getX() + 40 > enemyTank.getX()
                                    && this.getX() + 40 < enemyTank.getX() + 40
                                    && this.getY() + 60 > enemyTank.getY()
                                    && this.getY() + 60 < enemyTank.getY() + 60) {
                                return true;
                            }
                        }
                        //其他坦克左右方向
                        if (enemyTank.getDirection() == 1 || enemyTank.getDirection() == 3) {
                            //当前目标坦克的左下角坐标(this.getX(),this.getY()+60)
                            //比较的坦克x范围[enemyTank.getX(),enemyTank.getX()+60]
                            //比较的坦克y范围[enemyTank.getY(),enemyTank.getY()+40]
                            if (this.getX() > enemyTank.getX()
                                    && this.getX() < enemyTank.getX() + 60
                                    && this.getY() + 60 > enemyTank.getY()
                                    && this.getY() + 60 < enemyTank.getY() + 40) {
                                return true;
                            }
                            //当前目标坦克的右下角坐标(this.getX() + 40,this.getY()+60)
                            //比较的坦克x范围[enemyTank.getX(),enemyTank.getX()+60]
                            //比较的坦克y范围[enemyTank.getY(),enemyTank.getY()+40]
                            if (this.getX() + 40 > enemyTank.getX()
                                    && this.getX() + 40 < enemyTank.getX() + 60
                                    && this.getY() + 60 > enemyTank.getY()
                                    && this.getY() + 60 < enemyTank.getY() + 40) {
                                return true;
                            }

                        }
                    }
                }
                break;
            case 3://当前目标坦克向左
                //遍历坦克集合enemyTankVector判断
                for (int i = 0; i < enemyTankVector.size(); i++) {
                    //排除坦克集合enemyTankVector中的自己
                    EnemyTank enemyTank = enemyTankVector.get(i);
                    if (this != enemyTank) {
                        //根据其他坦克方向判断
                        //其他坦克上下方向
                        if (enemyTank.getDirection() == 0 || enemyTank.getDirection() == 3) {
                            //当前目标坦克的左上角坐标(this.getX(),this.getY())
                            //比较的坦克x范围[enemyTank.getX(),enemyTank.getX()+40]
                            //比较的坦克y范围[enemyTank.getY(),enemyTank.getY()+60]
                            if (this.getX() > enemyTank.getX()
                                    && this.getX() < enemyTank.getX() + 40
                                    && this.getY() > enemyTank.getY()
                                    && this.getY() < enemyTank.getY() + 60) {
                                return true;
                            }
                            //当前目标坦克的左下角坐标(this.getX(),this.getY()+40)
                            //比较的坦克x范围[enemyTank.getX(),enemyTank.getX()+40]
                            //比较的坦克y范围[enemyTank.getY(),enemyTank.getY()+60]
                            if (this.getX() > enemyTank.getX()
                                    && this.getX() < enemyTank.getX() + 40
                                    && this.getY() + 40 > enemyTank.getY()
                                    && this.getY() + 40 < enemyTank.getY() + 60) {
                                return true;
                            }
                        }

                        //其他坦克左右方向
                        if (enemyTank.getDirection() == 1 || enemyTank.getDirection() == 3) {
                            //当前目标坦克的左上角坐标(this.getX(),this.getY())
                            //比较的坦克x范围[enemyTank.getX(),enemyTank.getX()+60]
                            //比较的坦克y范围[enemyTank.getY(),enemyTank.getY()+40]
                            if (this.getX() > enemyTank.getX()
                                    && this.getX() < enemyTank.getX() + 60
                                    && this.getY() > enemyTank.getY()
                                    && this.getY() < enemyTank.getY() + 40) {
                                return true;
                            }
                            //当前目标坦克的左下角坐标(this.getX(),this.getY()+40)
                            //比较的坦克x范围[enemyTank.getX(),enemyTank.getX()+60]
                            //比较的坦克y范围[enemyTank.getY(),enemyTank.getY()+40]
                            if (this.getX() > enemyTank.getX()
                                    && this.getX() < enemyTank.getX() + 60
                                    && getY() + 40 > enemyTank.getY()
                                    && getY() + 40 < enemyTank.getY() + 40) {
                                return true;
                            }
                        }
                    }
                }
                break;
        }
        return false;
    }
}

