package com.jk.controller;

import com.jk.entity.User;
import com.jk.service.UserService;
import com.jk.utils.PayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by scc on 2018/8/22.
 */
@Controller
public class LoginController {
    @Autowired
    private UserService userService;
    @RequestMapping("login")
    public String doLogin(){

        return "login";
    }
    @RequestMapping("toLogin")
    public String toLogin(){

        return "login";
    }
    @RequestMapping("index")
    public String toIndex(){
        return "index";
    }

    /**
     * 注册方法
     * @return
     */
    @RequestMapping("toRegister")
    public String toRegister(){

        return "register";
    }

    /**
     * 执行注册
     * @return
     */
    @RequestMapping("register")
    public String doRegister(User user){
        String userId = PayUtils.roundUUID();
        user.setUserId(userId);
        user.setUserRealName(user.getUserName());
        userService.addUser(user);
        return "success";
    }
}
