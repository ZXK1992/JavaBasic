package com.zhu.battle_tanks.tank_game.game06;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Scanner;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/12/18 22:48
 * @description:
 */
public class ZxkTankGame06 extends JFrame {
    MyPanel mp = null;
    Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        new ZxkTankGame06();
    }

    public ZxkTankGame06() {
        System.out.println("请选择：新游戏(1)\t继续上局(2)");
        String key = sc.next();
        mp = new MyPanel(key);
        Thread thread = new Thread(mp);
        thread.start();
        this.add(mp);
        //设置标题
        this.setTitle("坦克大战");
        //设置窗口大小
        this.setSize(1250, 640);
        //设置窗口左上角坐标（居中）
        // this.setLocation(172,64);
        //设置窗口大小不可变
        this.setResizable(false);
        this.addKeyListener(mp);
        //点关闭按钮结束程序
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //设置窗口可见
        this.setVisible(true);
        //这里在JFrame中增加相应关闭窗口的处理
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                //System.out.println("监听");
                Recorder.keepRecord();
                System.exit(0);
            }
        });
    }
}
