package com.zhu.battle_tanks.draw;

import javax.swing.*;
import java.awt.*;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/11/26 22:42
 * @description:
 */
public class Drawcircle extends JFrame{
    //定义一个面板
    private MyPanel panel=null;

    public static void main(String[] args) {
        new Drawcircle();
        System.out.println("退出程序~");
    }
    public Drawcircle() {//构造器.md
        //初始化面板
        panel=new MyPanel();
        //把面板放入到窗口(画框)
        this.add(panel);
        //设置窗口的大小
        this.setSize(300,400);
        //当点击窗口的小×，程序完全退出.
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);//可以显示
    }
}
//1.先定义一个 MyPanel, 继承.md JPanel 类， 画图形，就在面板上画
class MyPanel extends JPanel{
    //说明:
    //1. MyPanel 对象就是一个画板
    //2. Graphics g 把 g 理解成一支画笔
    //3. Graphics 提供了很多绘图的方法
    //Graphics g
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        System.out.println("paint 方法被调用了~");
        g.drawOval(10,10,100,100);

    }
}
