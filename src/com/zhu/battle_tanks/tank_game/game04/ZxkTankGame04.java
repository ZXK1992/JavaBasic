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
        //设置标题
        this.setTitle("坦克大战");
        //设置窗口大小
        this.setSize(1020,640);
       //设置窗口左上角坐标（居中）
        this.setLocation(172,64);
        //设置窗口大小不可变
        this.setResizable(false);
        this.addKeyListener(mp);
        //点关闭按钮结束程序
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //设置窗口可见
        this.setVisible(true);
    }
}
