package com.zhu.oop2.smallchange.oop;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/11/6 17:03
 * @description: 面向对象编程
 * 一个功能对应一个方法
 */
public class SmallChangeSysOOP {
    boolean looper = true;
    Scanner scanner = new Scanner(System.in);
    String key = "";
    String detail = "-------------------零钱通明细-------------------";//明细
    double money = 0;//接收输入的金额
    double balance = 0;//余额
    String note = "";//消费项目
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    /**
     * 显示菜单
     */
    public void showMenu() {
        do {
            System.out.println("-------------------零钱通菜单(OOP)-------------------");
            System.out.println("\t\t\t\t\t 1 零钱通明细");
            System.out.println("\t\t\t\t\t 2 收益入账");
            System.out.println("\t\t\t\t\t 3 消费");
            System.out.println("\t\t\t\t\t 4 退     出");
            System.out.print("请选择(1-4):");
            key = scanner.next();
            switch (key) {
                case "1":
                    detail();
                    break;
                case "2":
                    income();
                    break;
                case "3":
                    consume();
                    break;
                case "4":
                    exit();
                    break;
                default:
                    System.out.println("");
            }
            System.out.println("\n");
        } while (looper);

    }

    /**
     * 零钱通明细
     */
    public void detail() {
        System.out.println(detail);
    }

    /**
     * 收益入账
     */
    public void income() {
        System.out.print("收益入账:");
        money = scanner.nextDouble();
        //找不正确的
        if (money <= 0) {
            System.out.println("收益入账应该大于0");
            return;
        }
        balance += money;
        detail += "\n收益入账\t +" + money + "\t" + sdf.format(new Date()) + "\t" + balance;
    }

    /**
     * 消费
     */
    public void consume() {
        System.out.print("消费金额:");
        money = scanner.nextDouble();
        //找不正确的
        if (money < 0 || money > balance) {
            System.out.println("消费金额应该在0-" + balance);
            return;
        }
        System.out.print("消费说明:");
        note = scanner.next();
        balance -= money;
        detail += "\n" + note + "\t -" + money + "\t" + sdf.format(new Date()) + "\t" + balance;
    }

    /**
     * 退出
     */
    public void exit() {
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
    }
}
