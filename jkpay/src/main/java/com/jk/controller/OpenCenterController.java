package com.jk.controller;

import com.jk.entity.AppInfo;
import com.jk.entity.User;
import com.jk.service.AppService;
import com.jk.utils.PayUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.SQLException;

/**
 * Created by scc on 2018/8/24.
 */
@Controller
public class OpenCenterController {
    @Autowired
    private AppService appService;
    /**
     * 添加应用服务
     * @return
     */
    @RequestMapping("addAppInfo")
    public String addOpenApp(AppInfo appInfo){
        //主键id
        String uuid = PayUtils.roundUUID();
        //生成appId
        String appId = PayUtils.generateAppId();
        appInfo.setId(uuid);
        appInfo.setAppId(appId);
        SimpleHash simpleHash = new SimpleHash("MD5", uuid, appInfo.getAppName(), 1024);
        appInfo.setSecretKey(simpleHash.toBase64());
        Subject sub = SecurityUtils.getSubject();
        User user =(User)sub.getPrincipal();
        appInfo.setUserId(user.getUserId());
        try {
            appService.addAppInfo(appInfo);
        }catch (SQLException e){
            e.printStackTrace();
           //出现sql异常回调此方法 重新生成
            addOpenApp(appInfo);
        }
        return "redirect:index";
    }

    /**
     * 跳转到新建应用页面
     * @return
     */
    @RequestMapping("newApp")
    public String toNewApp(){
        return "newapp";
    }

    /**
     * 跳转到应用管理页面
     * @return
     */
    @RequestMapping("toAppManager")
    public String appManager(){
        return "appmanager";
    }

    /**
     * 跳转到支付页面
     * @return
     */
    public String toPay(){
        return "";
    }
}
