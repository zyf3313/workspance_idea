package com.jk.service;

import com.jk.entity.User;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by scc on 2018/8/23.
 */
public interface UserService {
    /**
     * 新增用户信息
     * @param user
     */
    void addUser(User user);

    /**
     * 根据用户名查询用户对象
     * @param userName
     * @return
     */
    User getUserByUserName(String userName);
}
