package com.jk.service;

import com.jk.entity.AppInfo;

import java.sql.SQLException;

/**
 * Created by scc on 2018/8/24.
 */
public interface AppService {
    /**
     * 新增应用信息
     * @param appInfo
     */
    void addAppInfo(AppInfo appInfo) throws SQLException;
}
