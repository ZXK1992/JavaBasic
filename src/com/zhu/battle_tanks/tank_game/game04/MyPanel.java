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
    //定义炸弹集合,说明，当子弹击中坦克时，就加入一个bomb对象到bombs
    Vector<Bomb> bombs = new Vector<>();
    Image image1 = null;
    Image image2 = null;
    Image image3 = null;

    public MyPanel() {
        hero = new Hero(500, 200);//初始化自己坦克
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
            //启动敌人坦克对象
            new Thread(enemyTank).start();
            //加入
            enemyTanks.add(enemyTank);
        }

        //初始化图片对象
        image1 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/com/zhu/battle_tanks/tank_game/game04/img/bomb_1.gif"));
        image2 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/com/zhu/battle_tanks/tank_game/game04/img/bomb_2.gif"));
        image3 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/com/zhu/battle_tanks/tank_game/game04/img/bomb_3.gif"));
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0, 0, 1000, 600);
        //由于要画很多种坦克，所以封装成一个方法
        if (hero!=null&&hero.isLive()){
            //画出自己坦克-封装方法
            drawTank(hero.getX(), hero.getY(), g, 1, hero.getDirection());
        }
        //画我方坦克单个子弹
        if (hero.getShot() != null && hero.getShot().isLive()) {
            g.draw3DRect(hero.getShot().getX(), hero.getShot().getY(), 1, 1, false);
        }
        //将hero的多个子弹集合shots,遍历取出绘制
       /* Vector<Shot> shots = hero.getShots();
        for (int i = 0; i < shots.size(); i++) {
            Shot shot = shots.get(i);
            if (shot!=null&&shot.isLive()){
                g.draw3DRect(shot.getX(), shot.getY(), 1, 1, false);
            }else {//如果该shot对象已经无效,就从shots拿掉
                shots.remove(shot);
            }
        }*/
        //画出敌人的坦克，遍历Vector
        for (int i = 0; i < enemyTanks.size(); i++) {
            //遍历Vector从取出坦克
            EnemyTank enemyTank = enemyTanks.get(i);
            //判断当前坦克是否还存活
            if (enemyTank.isLive()) {//当敌人坦克是存活的，才画出该坦克
                drawTank(enemyTank.getX(), enemyTank.getY(), g, 0, enemyTank.getDirection());
                //画出enemyTank的所有子弹
                Vector<Shot> shotVector = enemyTank.getShots();
                for (int j = 0; j < shotVector.size(); j++) {
                    //取出子弹
                    Shot shot = shotVector.get(j);
                    //绘制
                    if (shot.isLive()) {//isLive==true
                        g.draw3DRect(shot.getX(), shot.getY(), 1, 1, false);
                    } else {
                        //从vector移除，如果不移除就一直在画
                        shotVector.remove(shot);
                    }
                }
            }
        }

        //如果bombs有对象，就画
        for (int i = 0; i < bombs.size(); i++) {
            //取出炸弹
            Bomb bomb = bombs.get(i);
            //根据当前这个bomb对象的life值去画对应的图片
            if (bomb.getLife() > 6) {
                g.drawImage(image1, bomb.getX(), bomb.getY(), 60, 60, this);
            } else if (bomb.getLife() > 3) {
                g.drawImage(image1, bomb.getX(), bomb.getY(), 60, 60, this);
            } else {
                g.drawImage(image1, bomb.getX(), bomb.getY(), 60, 06, this);

            }
            //让炸弹生命值减少，这样就会有个暂停状态
            bomb.lifeDown();
            //如果bomb的life为0，就从bombs删除
            if (bomb.getLife() == 0) {
                bombs.remove(bomb);
            }
        }
    }
//画我方子弹
 /*   public void drawShot(Vector<Shot> shots, Graphics g) {
        if (shots.size()>5){
            return;
        }
        for (int i = 0; i < shots.size(); i++) {
            Shot shot = shots.get(i);
            if (shot.isLive()){
                g.draw3DRect(shot.getX(), shot.getY(), 1, 1, false);

            }
        }
    }*/

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
                g.fillOval(x + 10, y + 20, 20, 20);//中间的圆盖
                g.drawLine(x + 20, y + 30, x + 20, y);//炮筒
                break;
            case 1://向右
                g.fill3DRect(x, y, 60, 10, false);//上边的轮子
                g.fill3DRect(x + 10, y + 10, 40, 20, false);//中间的盒子
                g.fill3DRect(x, y + 30, 60, 10, false);//下边轮子
                g.fillOval(x + 20, y + 10, 20, 20);//圆盖
                g.drawLine(x + 30, y + 20, x + 60, y + 20);//炮筒
                break;
            case 2://向下
                g.fill3DRect(x, y, 10, 60, false);//左边轮子
                g.fill3DRect(x + 10, y + 10, 20, 40, false);//中间的盒子
                g.fill3DRect(x + 30, y, 10, 60, false);//右边轮子
                g.fillOval(x + 10, y + 20, 20, 20);//中间的圆盖
                g.drawLine(x + 20, y + 30, x + 20, y + 60);//炮筒
                break;
            case 3://向左
                g.fill3DRect(x, y, 60, 10, false);//上边的轮子
                g.fill3DRect(x + 10, y + 10, 40, 20, false);//中间的盒子
                g.fill3DRect(x, y + 30, 60, 10, false);//下边轮子
                g.fillOval(x + 20, y + 10, 20, 20);//圆盖
                g.drawLine(x + 30, y + 20, x, y + 20);//炮筒
                break;
            default:
                System.out.println("暂时未处理");
        }
    }
    //如果我们的坦克可以发射多颗子弹
    //在判断我方子弹是否击中敌人坦克时，就需要把我们的子弹集合中
    //所以的子弹都取出来和敌人所有坦克，进行判断
    public void hitEnemyTank(){

        //发射单颗子弹的
        Shot shot = hero.getShot();
        if (shot!=null&& shot.isLive()){
            //遍历敌人坦克，并不知道子弹碰到哪个坦克，所以要遍历
            for (int i = 0; i < enemyTanks.size(); i++) {
                EnemyTank enemyTank = enemyTanks.get(i);
                hitTank(shot, enemyTank);
            }
        }
        //可以发射多颗子弹的
      /*  Vector<Shot> shots = hero.getShots();
        //遍历我们的子弹
        for (int j = 0; j < shots.size();j++) {
            Shot shot = shots.get(j);
            if (shot!= null && shot.isLive()) {//当我的子弹还存活，且不为空(没按J键时为空)
                //遍历敌人坦克，并不知道子弹碰到哪个坦克，所以要遍历
                for (int i = 0; i < enemyTanks.size(); i++) {
                    EnemyTank enemyTank = enemyTanks.get(i);
                    hitTank(shot, enemyTank);
                }
            }
        }*/

    }
    //编写方法，判断我方的子弹是否击中敌方坦克
    //什么时候判断，我方的子弹击中敌人坦克？你不知道什么时候，所以
    //放在循环里面判断，即run方法
    public void hitTank(Shot s, Tank tank) {
        //判断s击中坦克
        switch (tank.getDirection()) {
            case 0://坦克向上
            case 2://坦克向下
                if (s.getX() > tank.getX() && s.getX() < tank.getX() + 40 &&
                        s.getY() > tank.getY() && s.getY() < tank.getY() + 60) {//子弹落在敌人坦克区域
                    //子弹，敌人坦克死亡
                    s.setLive(false);
                    tank.setLive(false);
                    //当我方子弹击中敌方坦克后，将enemyTank从enemyTanks集合中去掉
                    //解决爆炸后反复爆炸
                    enemyTanks.remove(tank);
                    //创建bomb对象，加入到bombs集合
                    Bomb bomb = new Bomb(tank.getX(), tank.getY());
                    bombs.add(bomb);
                 /*   if (tank instanceof EnemyTank){
                        s.setLive(false);
                        tank.setLive(false);
                        enemyTanks.remove(tank);
                        //创建bomb对象，加入到bombs集合
                        Bomb bomb = new Bomb(tank.getX(), tank.getY());
                        bombs.add(bomb);
                    }else if (tank instanceof Hero){
                        s.setLive(false);
                        tank.setLive(false);
                        //创建bomb对象，加入到bombs集合
                        Bomb bomb = new Bomb(tank.getX(), tank.getY());
                        bombs.add(bomb);

                    }*/
                }
                break;
            case 1://坦克向右
            case 3://坦克向左
                if (s.getX() > tank.getX() && s.getX() < tank.getX() + 60 &&
                        s.getY() > tank.getY() && s.getY() < tank.getY() + 40) {
                    s.setLive(false);
                    tank.setLive(false);
                    enemyTanks.remove(tank);
                    //创建bomb对象，加入到bombs集合
                    Bomb bomb = new Bomb(tank.getX(), tank.getY());
                    bombs.add(bomb);
                    //当我方子弹击中敌方坦克后，将enemyTank从enemyTanks集合中去掉
                 /*   if (tank instanceof EnemyTank){
                        s.setLive(false);
                        tank.setLive(false);
                        enemyTanks.remove(tank);
                        //创建bomb对象，加入到bombs集合
                        Bomb bomb = new Bomb(tank.getX(), tank.getY());
                        bombs.add(bomb);
                    }else if (tank instanceof Hero){
                        s.setLive(false);
                        tank.setLive(false);
                        //创建bomb对象，加入到bombs集合
                        Bomb bomb = new Bomb(tank.getX(), tank.getY());
                        bombs.add(bomb);
                    }*/
                }
                break;
        }
    }

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
            if (hero.getY() > 0) {
                hero.moveUp();
            }
        } else if (e.getKeyCode() == KeyEvent.VK_D) {
            hero.setDirection(1);
            if ((hero.getX() +60)< 1000) {
                hero.moveRight();
            }
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            hero.setDirection(2);
            if ((hero.getY()+60) < 600) {
                hero.moveDown();
            }
        } else if (e.getKeyCode() == KeyEvent.VK_A) {
            hero.setDirection(3);
            if (hero.getX() > 0) {
                hero.moveLeft();
            }
        }
        //按下J键让子弹移动
        if (e.getKeyCode() == KeyEvent.VK_J) {
            //判断hero的子弹是否销毁（第一次射击前为空,或者子弹消亡了）
            //发射一颗子弹
            if (hero.getShot() == null || !hero.getShot().isLive()) {
                hero.shotEnemyTank();
            }
            //发射多颗子弹
            //hero.shotEnemyTank();
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
            //我方坦克只有一颗子弹的情况
            // 判断是否击中了敌人坦克
            /*if (hero.getShot() != null && hero.getShot().isLive()) {//当我的子弹还存活，且不为空(没按J键时为空)
                //遍历敌人坦克，并不知道子弹碰到哪个坦克，所以要遍历
                for (int i = 0; i < enemyTanks.size(); i++) {
                    EnemyTank enemyTank = enemyTanks.get(i);
                    hitTank(hero.getShot(), enemyTank);
                }
            }*/
            //我方坦克有多颗子弹，击中敌方坦克
            hitEnemyTank();
            //敌方坦克击中我方坦克
            hitHeroTank();
            this.repaint();
        }
    }
    //编写方法，判断敌人坦克是否击中我方坦克
    public void hitHeroTank() {
        //遍历敌方坦克
        for (int i = 0; i < enemyTanks.size(); i++) {
            EnemyTank enemyTank = enemyTanks.get(i);
            //遍历敌方每个坦克的子弹
            Vector<Shot> shots = enemyTank.getShots();
            for (int j = 0; j < shots.size(); j++) {
                Shot s = shots.get(j);
                if (hero.isLive()&& s.isLive()) {
                   hitTank(s,hero);
                }
            }

        }
    }
}
