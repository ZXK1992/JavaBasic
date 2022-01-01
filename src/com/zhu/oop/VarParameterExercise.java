package com.zhu.oop;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/10/1 17:04
 * @description:
 */
public class VarParameterExercise {
    public static void main(String[] args) {
        ZxkMethod zxkMethod = new ZxkMethod();
        zxkMethod.showScore("zxk", 50, 60, 70, 80, 90);
    }


}

class ZxkMethod {

    public String m1(String name, double score1, double score2) {
        return "姓名：" + name + "\t成绩" + (score1 + score2);
    }

    public String m2(String name, double score1, double score2, double score3) {
        return "姓名：" + name + "\t成绩" + (score1 + score2 + score3);
    }

    public String m3(String name, double score1, double score2, double score3, double score4, double score5) {
        return "姓名：" + name + "\t成绩" + (score1 + score2 + score3 + score4 + score5);
    }

    /**
     * 可变参数
     *
     * @param name
     * @param scores
     */
    public String showScore(String name, double... scores) {
        int sum = 0;
        for (int i = 0; i < scores.length; i++) {
            sum += scores[i];
        }
        String mes = "姓名：" + name + "\t成绩" + sum;
        return mes;
    }

}