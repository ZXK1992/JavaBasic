package com.zhu.battle_tanks.tank_game.game06;

import java.io.*;
import java.util.Vector;

/**
 * @author: ZHUXIAOKANG
 * @date: 2022/1/12 11:29
 * @description: 记录相关信息, 和文件交互，相当于工具类
 * 1.该类记录我方击毁敌方坦克数
 * 2.当游戏结束，将数据写入到文件
 * 3.如果需要恢复数据，启动游戏时就读回来
 */
public class Recorder {
    //记录我方坦克击毁敌人坦克数量
    private static int allEnemyTankNum = 0;
    //定义Vector，指向MyPanel对象的敌人坦克Vector
    private static Vector<EnemyTank>enemyTanks=new Vector<>();
    //定义一个Node的Vector，用于保存敌人信息的node对象
    private static Vector<Node>nodes=new Vector<>();
    //存盘，关闭游戏时准备写入recordFile文件的bw
    private static BufferedWriter bw = null;
    //继续游戏时读取recordFile文件的br
    private static BufferedReader br=null;

    //记录的文件
    //private static String recordFile = "D:\\myRecord.txt";
    //修改文件路径到src下
    private static String recordFile = "src\\myRecord.txt";
    public static void setEnemyTanks(Vector<EnemyTank> enemyTanks) {
        Recorder.enemyTanks = enemyTanks;
    }

    public static Vector<EnemyTank> getEnemyTanks() {
        return enemyTanks;
    }

    public static BufferedReader getBr() {
        return br;
    }

    public static void setBr(BufferedReader br) {
        Recorder.br = br;
    }

    public static String getRecordFile() {
        return recordFile;
    }

    public static void setRecordFile(String recordFile) {
        Recorder.recordFile = recordFile;
    }

    public static BufferedWriter getBw() {
        return bw;
    }

    public static void setBw(BufferedWriter bw) {
        Recorder.bw = bw;
    }

    public static int getAllEnemyTankNum() {
        return allEnemyTankNum;
    }
    //增加一个方法，当游戏接着关闭前玩时，我们将allEnemyTankNum和node信息读取,并返回所有剩余的Vector<Node>
    public static Vector<Node> getAllEnemyNumAndNodes(){
        //创建读流的对象
        try {
            br=new BufferedReader(new FileReader(recordFile));
            //读第一行
            String allEnemy = br.readLine();
            //剩余坦克数
            allEnemyTankNum = Integer.parseInt(allEnemy);
            //第二行开始每行读取的字符串
            String line="";
            //第二行循环读取
            while ((line=br.readLine())!=null){
                //根据空格分割字符串，构建node对象
                String[] xyd = line.split(" ");
                Node node = new Node(Integer.parseInt(xyd[0]), Integer.parseInt(xyd[1]),
                        Integer.parseInt(xyd[2]));
                nodes.add(node);//放入node Vector
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br!=null){
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return nodes;
    }
    //增加一个方法，当游戏退出时，我们将allEnemyTankNum保存到recordFile
    //同时将剩余敌方坦克写入recordFile，每一行表示一个
    public static void keepRecord() {
        try {
             bw = new BufferedWriter(new FileWriter(recordFile));
             bw.write(Recorder.getAllEnemyTankNum() + "\r\n");
             //遍历敌人坦克的Vector，然后根据情况保存即可
            for (int i = 0; i < enemyTanks.size(); i++) {
                EnemyTank enemyTank = enemyTanks.get(i);
                if (enemyTank.isLive()){
                    String record = enemyTank.getX() + " " + enemyTank.getY() + " " + enemyTank.getDirection();
                    bw.write(record+"\r\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bw!= null) {
                    bw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void setAllEnemyTankNum(int allEnemyTankNum) {
        Recorder.allEnemyTankNum = allEnemyTankNum;
    }

    //当我方坦克击毁一个敌人坦克，就应当allEnemyTankNum++；
    public static void addAllEnemyTankNum() {
        Recorder.allEnemyTankNum++;
    }
}
