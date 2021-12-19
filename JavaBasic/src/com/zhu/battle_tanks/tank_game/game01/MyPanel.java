package com.zhu.battle_tanks.tank_game.game01;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/12/16 22:34
 * @description: 坦克大战的绘图区域
 */
//1.先定义一个 MyPanel, 继承 JPanel 类， 画图形，就在面板上画
public class MyPanel extends JPanel implements KeyListener {
    //定义我的坦克
    Hero hero = null;

    public MyPanel() {
        hero = new Hero(100, 100);//初始化自己坦克
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0, 0, 1000, 750);//填充矩形，默认黑色
        //由于要画很多种坦克，所以封装成一个方法
        drawTank(hero.getX(), hero.getY(), g, 0, 0);
        drawTank(hero.getX() + 60, hero.getY(), g, 1, 0);
    }
    /**
     * @param x 坦克的左上角 x 坐标
     * @param y 坦克的左上角 y 坐标
     * @param g 画笔
     * @param direction 坦克方向（上下左右）
     * @param type 坦克类型
     */
    public void drawTank(int x, int y, Graphics g, int type, int direction) {
        switch (type) {
            case 0:
                g.setColor(Color.CYAN);
                break;
            case 1:
                g.setColor(Color.YELLOW);
                break;
        }
        switch (direction) {
            case 0:
                g.fill3DRect(x, y, 10, 60, false);
                g.fill3DRect(x + 10, y + 10, 20, 40, false);
                g.fill3DRect(x + 30, y, 10, 60, false);
                g.drawOval(x + 10, y + 20, 20, 20);
                g.drawLine(x + 20, y + 30, x + 20, y);
                break;
            default:
                System.out.println("暂时没有处理");
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println(e.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
