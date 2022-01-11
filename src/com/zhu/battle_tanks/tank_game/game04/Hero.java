package com.zhu.battle_tanks.tank_game.game04;

import java.util.Vector;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/12/16 22:29
 * @description:此类表示我方坦克
 */
public class Hero extends Tank {
    //定义一个shot对象，表示一个射击(线程)
    private Shot shot;
    //可以发射多颗子弹
    private Vector<Shot> shots = new Vector<>();
    //发射子弹
    public void shotEnemyTank(){
        //控制同一时间在面板是只有5颗子弹
        /*if (shots.size()==3){
            return;
        }*/
        switch (getDirection()){
            case 0://向上
               shot= new Shot(getX()+20,getY(),0);
                break;
            case 1://向右
                shot= new Shot(getX()+60,getY()+20,1);
                break;
            case 2://向下
                shot= new Shot(getX()+20,getY()+60,2);
                break;
            case 3://向左
                shot= new Shot(getX(),getY()+20,3);
                break;
        }
        //新创建的shot子弹加入shots集合
        //shots.add(shot);
        //启动shot线程
        new Thread(shot).start();

    }

    public Vector<Shot> getShots() {
        return shots;
    }

    public void setShots(Vector<Shot> shots) {
        this.shots = shots;
    }

    public Shot getShot() {
        return shot;
    }

    public void setShot(Shot shot) {
        this.shot = shot;
    }

    public Hero(int x, int y) {
        super(x, y);
    }


}
