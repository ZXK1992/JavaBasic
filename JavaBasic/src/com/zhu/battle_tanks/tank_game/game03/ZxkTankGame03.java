package com.zhu.battle_tanks.tank_game.game03;

import javax.swing.*;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/12/18 22:48
 * @description:
 */
public class ZxkTankGame03 extends JFrame{
    MyPanel mp =null;
    public static void main(String[] args) {
        new ZxkTankGame03();
    }
    public ZxkTankGame03(){
        mp=new MyPanel();
        Thread thread = new Thread(mp);
        thread.start();
        this.add(mp);
        this.setSize(1000,500);
        this.addKeyListener(mp);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
