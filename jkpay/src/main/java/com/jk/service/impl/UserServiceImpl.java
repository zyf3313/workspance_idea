package com.jk.service.impl;

import com.jk.entity.User;
import com.jk.mapper.UserMapper;
import com.jk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by scc on 2018/8/23.
 */
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userMapper;
    @Override
    public void addUser(User user) {
        userMapper.saveUser(user);
    }

    @Override
    public User getUserByUserName(String userName) {
        return userMapper.queryUserByUserName(userName);
    }
}
