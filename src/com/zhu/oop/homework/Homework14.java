package com.zhu.oop.homework;

import java.util.Random;
import java.util.Scanner;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/10/26 11:18
 * @description: 有个人Tom设计他的成员变量，成员方法，可以电脑猜拳，
 * 电脑每次都会随机生成0,1,2
 * 0表示 石头 ，1表示 剪刀 ，2 表示 布
 * 并要求可以显示Tom的输赢次数(清单)
 */
public class Homework14 {
    public static void main(String[] args) {
        //创建一个玩家对象
        Tom tom = new Tom();
        //用来记录最后输赢的次数
        int isWinCount=0;
        // 创建一个二维数组，用来接收局数，Tom出拳情况以及电脑出拳情况
        int[][] arr1 = new int[3][3];
        int j = 0;
        // 创建一个一维数组，用来接收输赢情况
        String[] arr2 = new String[3];
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            System.out.println("请玩家出拳，0表示 石头 ，1表示 剪刀 ，2 表示 布");
            //获取玩家出的拳
           int num = scanner.nextInt();
           tom.setPlayerNum(num);
            int player = tom.getPlayerNum();
            arr1[i][j+1]=player;

            //获取电脑出的拳
            int com = tom.computerNum();
            arr1[i][j + 2] = com;

            //将玩家猜的拳与电脑做比较
            String isWin = tom.vsComputer();
            arr2[i]=isWin;
            arr1[i][j]= tom.count;
            // 对每一局的情况进行输出
            System.out.println("=========================================");
            System.out.println("局数\t玩家的出拳\t电脑的出拳\t输赢情况");
            System.out.println(tom.count+"\t\t"+player+"\t\t\t"+com+"\t\t\t"+isWin);
            System.out.println("=========================================");
            System.out.println("\n\n");
            isWinCount = tom.winCount(isWin);
            System.out.println("赢的次数"+isWinCount);
            System.out.println();
        }


    }
}

class Tom {
    //玩家出拳的类型
    int playerNum;
    //电脑出拳的类型
    int comNum;
    //玩家赢的次数
    int winCountNum;
    //比赛的次数
    int count; //一共比赛3次
    /**
     * 与电脑猜拳
     *
     * @return
     */
    public String vsComputer() {
        if (playerNum == 0 && comNum == 1) {
            return "你赢了";
        } else if (playerNum == 1 && comNum == 2) {
            return "你赢了";
        } else if (playerNum == 2 && comNum == 0) {
            return "你赢了";
        } else if (playerNum == comNum) {
            return  "平手";
        } else {
           return "你输了";
        }
    }

    /**
     * 电脑产生的猜拳代号
     *
     * @return
     */
    public int computerNum() {
        Random random = new Random();
        int rNum = random.nextInt(3);
        return rNum;
    }

    public int getPlayerNum() {
        return playerNum;
    }

    /**
     * 设置玩家猜拳的数字
     * @param playerNum
     */
    public void setPlayerNum(int playerNum) {
        if (playerNum>2||playerNum<0){
            throw new IllegalArgumentException("数字输入有误");
        }
        this.playerNum = playerNum;
    }

    public void showInfo(int count) {

    }

    /**
     * 记录玩家赢的次数
     * @param s
     * @return
     */
    public int winCount(String s){
        count++; //控制玩的次数
        if (s.equals("你赢了")){//统计赢的次数
            winCountNum++;
        }
        return winCountNum;
    }

}