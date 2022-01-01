package com.zhu.battle_tanks.tank_game.game02;

import javax.swing.*;
import java.awt.*;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/12/18 22:48
 * @description:
 */
public class ZxkTankGame02 extends JFrame{
    MyPanel mp =null;
    public static void main(String[] args) {
        new ZxkTankGame02();
    }
    public ZxkTankGame02(){
        mp=new MyPanel();
        this.add(mp);
        this.setSize(1000,500);
        this.addKeyListener(mp);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
