package com.zhu.battle_tanks.tank_game.game04;


import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

/**
 * 坦克大战的绘图区域
 */
//为了监听 键盘事件，实现KeyListener
public class MyPanel extends JPanel implements KeyListener, Runnable {
    //定义我的坦克
    Hero hero = null;
    /*
    画3辆敌人坦克，颜色为青
    分析：
        1.因为敌人的坦克，是在MyPanel上，所以我们代码在MyPanel
        2.因为敌人的坦克，后面有自己特殊的属性和方法，可以单开一个EnemyTank类
        3.敌人坦克数量多，可以放入到集合Vector，因为考虑多线程问题
     */
    //定义敌人坦克，放入到 Vector
    Vector<EnemyTank> enemyTanks = new Vector<>();
    int enemyTankSize = 3;

    public MyPanel() {
        hero = new Hero(200, 200);//初始化自己坦克
        hero.setSpeed(2);
        //初始化敌人坦克
        for (int i = 0; i < enemyTankSize; i++) {
            //创建一个敌人的坦克
            EnemyTank enemyTank = new EnemyTank((100 * (i + 1)), 0);
            //设置方向
            enemyTank.setDirection(2);
            //给该enemyTank放一颗子弹
            Shot shot = new Shot(enemyTank.getX() + 20, enemyTank.getY() + 60, enemyTank.getDirection());
           //把shot加入enemyTank的Vector成员
            enemyTank.getShots().add(shot);
            //启动shot对象
            new Thread(shot).start();
            //加入
            enemyTanks.add(enemyTank);
        }

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0, 0, 1000, 750);
        //由于要画很多种坦克，所以封装成一个方法
        //画出自己坦克-封装方法
        drawTank(hero.getX(), hero.getY(), g, 1, hero.getDirection());
        //画出敌人的坦克，遍历Vector
        for (int i = 0; i < enemyTanks.size(); i++) {
            //取出坦克
            EnemyTank enemyTank = enemyTanks.get(i);
            drawTank(enemyTank.getX(), enemyTank.getY(), g, 0, enemyTank.getDirection());
            //画出enemyTank的所有子弹
            Vector<Shot> shotVector = enemyTank.getShots();
            for (int j = 0; j < shotVector.size(); j++) {
                //取出子弹
                Shot shot = shotVector.get(j);
                //绘制
                if (shot.isLive()){//isLive==true
                    g.draw3DRect(shot.getX(),shot.getY(),1,1,false);
                }else {
                    //从vector移除，如果不移除就一直在画
                    shotVector.remove(shot);
                }
            }
        }

        //画子弹
        if (hero.getShot() != null && hero.getShot().isLive() == true) {
            g.draw3DRect(hero.getShot().getX(), hero.getShot().getY(), 1, 1,false);
        }
    }

    /**
     * @param x         坦克的左上角 x 坐标
     * @param y         坦克的左上角 y 坐标
     * @param g         画笔
     * @param direction 坦克方向（上下左右）
     * @param type      坦克类型
     */
    public void drawTank(int x, int y, Graphics g, int type, int direction) {
        switch (type) {
            case 0://敌人的坦克
                g.setColor(Color.CYAN);
                break;
            case 1: //我的坦克
                g.setColor(Color.YELLOW);
                break;
        }
        //根据不同方向的坦克绘制对应形状的坦克
        //direction表示方向（0：向上，1 向右，2 向下，3向左
        switch (direction) {
            case 0://向上
                g.fill3DRect(x, y, 10, 60, false);//左边轮子
                g.fill3DRect(x + 10, y + 10, 20, 40, false);//中间的盒子
                g.fill3DRect(x + 30, y, 10, 60, false);//右边轮子
                g.drawOval(x + 10, y + 20, 20, 20);//中间的圆盖
                g.drawLine(x + 20, y + 30, x + 20, y);//炮筒
                break;
            case 1://向右
                g.fill3DRect(x, y, 60, 10, false);//上边的轮子
                g.fill3DRect(x + 10, y + 10, 40, 20, false);//中间的盒子
                g.fill3DRect(x, y + 30, 60, 10, false);//下边轮子
                g.drawOval(x + 20, y + 10, 20, 20);//圆盖
                g.drawLine(x + 30, y + 20, x + 60, y + 20);//炮筒
                break;
            case 2://向下
                g.fill3DRect(x, y, 10, 60, false);//左边轮子
                g.fill3DRect(x + 10, y + 10, 20, 40, false);//中间的盒子
                g.fill3DRect(x + 30, y, 10, 60, false);//右边轮子
                g.drawOval(x + 10, y + 20, 20, 20);//中间的圆盖
                g.drawLine(x + 20, y + 30, x + 20, y + 60);//炮筒
                break;
            case 3://向左
                g.fill3DRect(x, y, 60, 10, false);//上边的轮子
                g.fill3DRect(x + 10, y + 10, 40, 20, false);//中间的盒子
                g.fill3DRect(x, y + 30, 60, 10, false);//下边轮子
                g.drawOval(x + 20, y + 10, 20, 20);//圆盖
                g.drawLine(x + 30, y + 20, x, y + 20);//炮筒
                break;
            default:
                System.out.println("暂时未处理");
        }
    }

    //编写方法，判断我方的子弹是否击中敌方坦克


    @Override
    public void keyTyped(KeyEvent e) {

    }

    //我方坦克通过按键控制上右下左（wdsa表示）的移动
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W) {
            //改变坦克的方向
            hero.setDirection(0);
            //修改坦克的坐标
            hero.moveUp();
        } else if (e.getKeyCode() == KeyEvent.VK_D) {
            hero.setDirection(1);
            hero.moveRight();
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            hero.setDirection(2);
            hero.moveDown();
        } else if (e.getKeyCode() == KeyEvent.VK_A) {
            hero.setDirection(3);
            hero.moveLeft();
        }
        //按下J键让子弹移动
        if (e.getKeyCode() == KeyEvent.VK_J) {
            hero.shot();

            new Thread(hero.getShot()).start();
        }
        //让面板重绘
        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //判断是否击中了敌人坦克
            
            this.repaint();
        }
    }
}
