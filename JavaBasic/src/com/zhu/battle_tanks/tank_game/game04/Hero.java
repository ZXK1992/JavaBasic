package com.zhu.battle_tanks.tank_game.game04;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/12/16 22:29
 * @description:此类表示我方坦克
 */
public class Hero extends Tank {
    private Shot shot;
    public void shot(){
        switch (getDirection()){
            case 0:
               shot= new Shot(getX()+20,getY(),getDirection());
                break;
            case 1:
                shot= new Shot(getX()+60,getY()+20,getDirection());
                break;
            case 2:
                shot= new Shot(getX()+20,getY()+60,getDirection());
                break;
            case 3:
                shot= new Shot(getX(),getY()+20,getDirection());
                break;
        }

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
