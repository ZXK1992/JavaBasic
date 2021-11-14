package com.zhu.oop2.smallchange;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/11/5 21:49
 * @description:
 * 面向过程编程
 */
public class SmallChangeSys {
    public static void main(String[] args) {
        boolean looper = true;
        Scanner scanner = new Scanner(System.in);
        String key = "";
        String detail = "-------------------零钱通明细-------------------";//明细
        double money = 0;//接收输入的金额
        double balance = 0;//余额
        String note = "";//消费项目
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        do {
            System.out.println("-------------------零钱通菜单-------------------");
            System.out.println("\t\t\t\t\t 1 零钱通明细");
            System.out.println("\t\t\t\t\t 2 收益入账");
            System.out.println("\t\t\t\t\t 3 消费");
            System.out.println("\t\t\t\t\t 4 退     出");
            System.out.print("请选择(1-4):");
            key = scanner.next();
            switch (key) {
                case "1":
                    System.out.println(detail);
                    break;
                case "2":
                    System.out.print("收益入账:");
                    money = scanner.nextDouble();
                    //找不正确的
                    if (money<=0){
                        System.out.println("收益入账应该大于0");
                        break;
                    }
                    balance += money;
                    detail += "\n收益入账\t +" + money + "\t" + sdf.format(new Date()) + "\t" + balance;
                    break;
                case "3":
                    System.out.print("消费金额:");
                    money = scanner.nextDouble();
                    //找不正确的
                    if (money<0 ||money>balance){
                        System.out.println("消费金额应该在0-"+balance);
                        break;
                    }
                    System.out.print("消费说明:");
                    note = scanner.next();
                    balance -= money;
                    detail += "\n" + note + "\t -" + money + "\t" + sdf.format(new Date()) + "\t" + balance;
                    break;
                case "4":
                    String choice = "";//退出时指令
                    while (true) {
                        System.out.println("你确定要退出吗？y/n");
                        choice = scanner.next();
                        if ("y".equals(choice) || "n".equals(choice)) {
                            break;
                        }
                    }
                    if ("y".equals(choice)) {
                        looper = false;
                    }
                    break;
                default:
                    System.out.println("");
            }
            System.out.println("\n");
        } while (looper);

        System.out.println("退出零钱通");
    }
}
