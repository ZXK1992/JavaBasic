package com.zhu.excption_;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/11/22 11:17
 * @description:
 */
public class ExceptionExercise01 {
    public static int method() {
        int i = 1;
        try {
            i++;
            String[] names = new String[3];
            if (names[1].equals("tom")) {//空指针
                System.out.println(names[1]);
            } else {
                names[3] = "hspedu";
            }
            return 1;
        } catch (ArrayIndexOutOfBoundsException e) {
            return 2;
        } catch (NullPointerException e) {
            return ++i;//i=3 => 保存临时变量 temp = 3
        } finally {
            ++i;
            System.out.println("i=" + i);
        }
    }

    public static void main(String[] args) {
        System.out.println(method());
    }
}
