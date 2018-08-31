package com.jk.entity;

import java.io.Serializable;

/**
 * @创建人 yangfan zhang
 * @创建时间 2018/8/27 10:12
 * @描述
 */
public class WebSet implements Serializable {

    private static final long serialVersionUID = -5734643242510230407L;

    /**应用管理id*/
    private String id;
    /**appid*/
    private String appId;
    /**站点名称*/
    private String appName;
    /**站点域名*/
    private String appGateway;
    /**回调路径*/
    private String notifyurl;
    /**用户id*/
    private String userId;

    private String secretKey;

    /**业务字段*/
    private String userName;

    private String url;

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getAppGateway() {
        return appGateway;
    }

    public void setAppGateway(String appGateway) {
        this.appGateway = appGateway;
    }

    public String getNotifyurl() {
        return notifyurl;
    }

    public void setNotifyurl(String notifyurl) {
        this.notifyurl = notifyurl;
    }

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

    @Override
    public String toString() {
        return "WebSet{" +
                "id='" + id + '\'' +
                ", appId='" + appId + '\'' +
                ", appName='" + appName + '\'' +
                ", appGateway='" + appGateway + '\'' +
                ", notifyurl='" + notifyurl + '\'' +
                ", userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }
}
