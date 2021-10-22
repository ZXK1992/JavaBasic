package com.zhu.controlstructure;

import java.util.Scanner;

public class MulForExercise01 {
    public static void main(String[] args) {
        //1.统计3个班成绩情况，每个班5名同学。求出各个班的平均分和所有
        //班级的平均分（学生成绩从键盘能输入）
        double score = 0;//学生成绩
        double totalSum = 0;//所有班总分
        int totalcount = 0;//所有班及格人数
        int classNum = 3;//班级数
        int stuNum = 5;//学生数
        Scanner scanner = new Scanner(System.in);
        for (int i = 1; i <= classNum; i++) {
            int count = 0; //每个班及格人数
            double sum = 0;//每个班总分
            for (int j = 1; j <= stuNum; j++) {
                System.out.println("请输入第" + i + "班第" + j + "学生的成绩：");
                score = scanner.nextDouble();
                if (score >= 60) {
                    count++;
                    totalcount++;
                }
                sum += score;
                totalSum += score;
            }
            //求出各个班的平均分
            System.out.println("第" + i + "个班总分" + sum );
            System.out.println("第" + i + "个班平均分" + sum / stuNum);
            System.out.println("第" + i + "个班及格人数" + count);
        }
        //所有班级的平均分
        System.out.println("所有班级的平均分" + totalSum);
        System.out.println("所有班级的平均分" + totalSum / (classNum * stuNum));
        System.out.println("所有班及格人数" + totalcount);
    }
}
