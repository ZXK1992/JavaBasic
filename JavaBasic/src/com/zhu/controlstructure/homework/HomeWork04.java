package com.zhu.controlstructure.homework;

public class HomeWork04 {
    public static void main(String[] args) {
/*
输出小写的a-z，以及的Z-A
考察我们对a-z编码和for的综合
思路分析
1.'b' = 'a'+1 c= 'a'+2;
2.使用for搞定
*/
  for (char a = 'a';a<='z';a++){
      System.out.print(a+" ");
  }
        System.out.println();
        for (char b = 'Z'; b>='A';b--){
            System.out.print(b);
        }
    }

}
