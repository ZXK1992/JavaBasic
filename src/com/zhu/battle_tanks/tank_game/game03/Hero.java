package com.zhu.battle_tanks.tank_game.game03;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/12/16 22:29
 * @description:此类表示我方坦克
 */
public class Hero extends Tank {
    //定义一个Shot对象，表示一个射击行为（线程）
    private Shot shot;
    //射击，因为是我方坦克触发的射击
    public void shotEnemy(){
        //创建shot对象，要根据当前hero对象的位置和方向来创建shot
        switch (getDirection()){//得到hero对象的方向
            case 0://向上
               shot= new Shot(getX()+20,getY(),0);//根据坦克坐标计算子弹坐标
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
        //启动子弹线程
        new Thread(shot).start();
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
