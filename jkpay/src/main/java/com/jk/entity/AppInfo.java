package com.jk.entity;

import java.io.Serializable;

/**
 * Created by scc on 2018/8/24.
 */
public class AppInfo implements Serializable{
    private static final long serialVersionUID = -8295089893484660391L;
    /**主键id*/
    private String id;
    /**应用id*/
    private String appId;
    /**应用名称*/
    private String appName;
    /**应用网关*/
    private String appGateway;
    /**异步回调地址*/
    private String notifyUrl;
    /**关联用户id*/
    private String userId;
    /**安全密钥*/
    private String secretKey;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppGateway() {
        return appGateway;
    }

    public void setAppGateway(String appGateway) {
        this.appGateway = appGateway;
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }
}
