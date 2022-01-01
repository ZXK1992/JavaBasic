package com.zhu.oop.homework;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/10/5 9:43
 * @description:
 */
public class Homework02 {
    public static void main(String[] args) {
        A02 a02 = new A02();
        String[] arr = {"Color.java", "ccc", "zkx"};
        String str = "zxk";
        Integer index = a02.find(arr, str);
      if (index!=null){
          System.out.println(index);
      }else {
          System.out.println("arr数组不能为null或{}");
      }
    }
}

/**
 * 编写A02。定义方法find ，实现查找某字符串数组中的元素，并返回索引，找不到返回-1
 */
class A02 {
    //实现查找某字符串数组中的元素，并返回索引，找不到返回-1
    public Integer find(String[] arr, String str) {
        if (arr != null && arr.length > 0) {
            for (int i = 0; i < arr.length; i++) {
                if (str.equals(arr[i])) {
                    return i;
                }
            }
            //如果没有就返回-1
            return -1;
        }
        return null;
    }
}