package com.zhu.qq_simulation.QQClient.src.com.zxk.qqcommon;

import java.io.Serializable;

/**
 * @author: ZHUXIAOKANG
 * @date: 2022/1/26 10:16
 * @description:
 */
public class User implements Serializable {
    private final static long serialVersionUID=1L;
    //用户id/用户名
    private String userId;
    //用户密码
    private String passwd;

    public User() {
    }

    public User(String userId, String passwd) {
        this.userId = userId;
        this.passwd = passwd;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPwd() {
        return passwd;
    }

    public void setPwd(String passwd) {
        this.passwd = passwd;
    }
}
