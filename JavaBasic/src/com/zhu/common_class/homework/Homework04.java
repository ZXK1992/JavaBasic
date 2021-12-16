package com.zhu.common_class.homework;

import java.util.Scanner;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/11/25 0:28
 * @description:
 */
public class Homework04 {
    /*
    输入字符串，判断里面有多少个大写字母，多少个小写字母，多少个数字
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入字符串:");
        String input = scanner.next();
        char[] chars = input.toCharArray();
        int upCount = 0;
        int lowCount = 0;
        int numCount = 0;
        int otherCount = 0;
        for (char aChar : chars) {
            if (aChar >= 'A'/*65*/ && aChar <= 'Z'/*90*/) {//字符为大写
                upCount++;
            }
            else if (aChar >= 'a'/*97*/ && aChar <='z' /*122*/) {//字符为小写
                lowCount++;
            }
//            else if (Character.isDigit(aChar)){
//                numCount++;
//            }
            else if (aChar>='0'&&aChar<='9'){//字符为数字
                numCount++;
            }else {
                otherCount++;
            }

        }
        System.out.println("大写字母："+upCount);
        System.out.println("小写字母："+lowCount);
        System.out.println("数字："+numCount);
        System.out.println("其他符号："+otherCount);
    }
}
