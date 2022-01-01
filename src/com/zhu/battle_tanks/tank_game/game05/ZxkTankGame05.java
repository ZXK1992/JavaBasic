package com.zhu.battle_tanks.tank_game.game05;

import javax.swing.*;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/12/18 22:48
 * @description:
 */
public class ZxkTankGame05 extends JFrame{
    MyPanel mp =null;
    public static void main(String[] args) {
        new ZxkTankGame05();
    }
    public ZxkTankGame05(){
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
