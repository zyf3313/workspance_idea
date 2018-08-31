package com.jk.service.impl;

import com.jk.entity.AppInfo;
import com.jk.mapper.AppMapper;
import com.jk.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

/**
 * Created by scc on 2018/8/24.
 */
@Service
public class AppServiceImpl implements AppService{
    @Autowired
    private AppMapper appMapper;
    @Override
    public void addAppInfo(AppInfo appInfo) throws SQLException{
        appMapper.saveAppInfo(appInfo);
    }
}
