package com.zhu.battle_tanks.tank_game.game01;

import javax.swing.*;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/11/26 22:42
 * @description:
 */
public class ZxkTankGame01 extends JFrame{
    //定义一个面板
      MyPanel mp=null;

    public static void main(String[] args) {
        ZxkTankGame01 zxkTankGame01 = new ZxkTankGame01();
    }
    public ZxkTankGame01() {//构造器.md
        //初始化面板
        mp=new MyPanel();
        //把面板放入到窗口(就是游戏的绘图区域)
        this.add(mp);
        //设置窗口的大小
        this.setSize(1000,750);
        //当点击窗口的小×，程序完全退出.
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);//可以显示
    }
}


