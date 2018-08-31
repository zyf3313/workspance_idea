package com.jk.entity;

import java.io.Serializable;

/**
 * Created by scc on 2018/8/23.
 */
public class User implements Serializable{
    private static final long serialVersionUID = 6909883515394426380L;

    private String userId;
    private String userName;
    private String userRealName;
    private String userPassword;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserRealName() {
        return userRealName;
    }

    public void setUserRealName(String userRealName) {
        this.userRealName = userRealName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}
