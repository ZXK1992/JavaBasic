package com.zhu.common_class.homework;

import java.util.Scanner;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/11/25 0:28
 * @description:
 */
public class Homework03 {
    /*
    1)编写java程序，输入形式为：Han shun Ping，以Ping,Han.S的形式打印
    出来，其中.S是中间单词的首字母
    2）例如输入"Willian Jefferson Clinton",输出形式：Clinton，Willian.J
     */
    public static void main(String[] args) {
        System.out.println("输入名字：");
        Scanner scanner = new Scanner(System.in);
        String inputName = scanner.nextLine();
        System.out.println(inputName);
        if (!inputName.equals("")&&inputName!=null){
            String[] s = inputName.split(" ");
            StringBuffer sb = new StringBuffer();
            sb.append(s[s.length-1]).append(",");
            for (int i = 0; i < s.length-1; i++) {
                if (i==0){
                    sb.append(s[i]);
                }else {
                    sb.append(".").append(s[i].charAt(0));
                }
            }
            System.out.println(sb);
        }else {
            System.out.println("输入名字为空");
        }
    }
}

class Homework03Next{
    public static void main(String[] args) {
        String name="Zhu Xiao Kang";
        String[] split = name.split(" ");
        if (split.length!=3){
            System.out.println("输入的名字有误");
        }

        String format = String.format("%s,%s.%c", split[2], split[1], split[0].toUpperCase().charAt(0));
        System.out.println(format);
    }
}
