package com.zhu.common_class.homework;

import java.util.Scanner;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/11/24 23:11
 * @description:
 */
public class Homework02 {
    /*
    输入用户名、密码、邮箱，如果信息录入正确，则提示注册成功，否则
    生成异常对象
    要求：
    1）用户名长度为2或3或4
    2）密码长度为6 ，要求全是数字（isDigital方法）
    3）邮箱中包含@和.，并且@在.前面
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入用户名：");
        String name = scanner.next();
        System.out.println("输入密码：");
        String pwd = scanner.next();
        System.out.println("输入邮箱：");
        String email = scanner.next();
        try {
            userRegister(name,pwd,email);
            System.out.println("注册成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 注册
     * @param name
     * @param pwd
     * @param email
     */
    public static void userRegister(String name, String pwd, String email) {
        if ((name == null || "".equals(name)) && (pwd == null || "".equals(pwd))
                && (email == null || "".equals(email))) {
            throw new UserException("用户名，密码，邮箱不能为空");
        }
        if (!(name.length() >= 2 && name.length() <= 4)) {
            throw new UserException("用户名应该长度为2或3或4");
        }
        if (!(pwd.length() == 6 && isDigital(pwd))) {
            throw new UserException("密码应该长度为6，要求全是数字");
        }
        int atInx = email.lastIndexOf("@");
        int dotInx = email.lastIndexOf(".");
        if (!(atInx > 0 &&
                atInx < dotInx)) {
            throw new UserException("邮箱中应该包含@和. 并且@在.前面");
        }
    }

    /**
     * 是否为数字
     * @param pwd
     * @return
     */
    private static boolean isDigital(String pwd) {
        char[] chars = pwd.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] < '0' || chars[i] > '9') {
                return false;
            }
        }
        return true;
    }
}

/**
 * 自定义用户异常
 */
class UserException extends RuntimeException {
    public UserException(String message) {
        super(message);
    }
}
