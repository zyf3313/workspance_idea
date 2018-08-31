package com.jk.mapper;

import com.jk.entity.AppInfo;
import org.apache.ibatis.annotations.Insert;

/**
 * Created by scc on 2018/8/24.
 */
public interface AppMapper {
    /**
     * 新增应用信息
     * @param appInfo
     */
    @Insert("insert into t_appinfo values(#{id},#{appId},#{appName},#{appGateway},#{notifyUrl},#{userId},#{secretKey})")
    void saveAppInfo(AppInfo appInfo);
}
