package com.zhu.operator;

/**
 * 位运算.md
 */
public class BitOperator {
    public static void main(String[] args) {
//        System.md.out.println(2 & 3);
//        System.md.out.println(2 | 3);
//        System.md.out.println(~ -2);
//        System.md.out.println(~ 2);
//        System.md.out.println(2 ^ 3);
//        int i  = 66;
//        System.md.out.println(++ i + i);
        //~-5 = ?
        //原码 10000000 00000000 00000000 00000101
        //反码 11111111 11111111 11111111 11111010
        //补码 11111111 11111111 11111111 11111011
        //运算补码取反 00000000 00000000 00000000 00000100 ,得到正数，原码同补码
        //~-5 =4;
        //2&3=?
        //00000000 00000000 00000000 00000010
        //00000000 00000000 00000000 00000011
        //2&3=2;

        //~2 = ?
        //原码 00000000 00000000 00000000 00000010
        //补码 00000000 00000000 00000000 00000010
        //运算补码 11111111 11111111 11111111 11111101
        //负数反码 11111111 11111111 11111111 11111100
        //原码    10000000 00000000 00000000 00000011
        //~2 = -3

        //13&7=?
        //13原码 原码 00000000 00000000 00000000 0001101
        //7原码 原码  00000000 00000000 00000000 0000111
        //          00000000 00000000 00000000 0000101
        //13&7=5;
        // 5|4=?
        //  00000000 00000000 00000000 0000101
        //  00000000 00000000 00000000 0000100
        //  00000000 00000000 00000000 0000101
        // 5|4=5;

        //-3^3=?
       // -3 原码    10000000 00000000 00000000 00000011
       // -3 反码    11111111 11111111 11111111 11111100
        //-3 补码    11111111 11111111 11111111 11111101
        //3补码      00000000 00000000 00000000 00000011
     // 进行^运算补码 11111111 11111111 11111111 11111110
        //反码 11111111 11111111 11111111 11111101
        //原码 10000000 00000000 00000000 00000010
        //-3^3=-2
        System.out.println(~-5);
        System.out.println(2&3);
        System.out.println(~2);
        System.out.println(13&7);
        System.out.println(5|4);
        System.out.println(-3^3);
        System.out.println();


    }
}
