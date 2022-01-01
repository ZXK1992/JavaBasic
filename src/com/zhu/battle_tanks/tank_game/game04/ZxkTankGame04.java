package com.zhu.battle_tanks.tank_game.game04;

import javax.swing.*;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/12/18 22:48
 * @description:
 */
public class ZxkTankGame04 extends JFrame{
    MyPanel mp =null;
    public static void main(String[] args) {
        new ZxkTankGame04();
    }
    public ZxkTankGame04(){
        mp=new MyPanel();
        Thread thread = new Thread(mp);
        thread.start();
        this.add(mp);
        this.setSize(1020,640);
        this.addKeyListener(mp);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
