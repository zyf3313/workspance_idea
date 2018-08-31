package com.jk.mapper;

import com.jk.entity.WebSet;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @创建人 yangfan zhang
 * @创建时间 2018/8/27 10:57
 * @描述
 */
public interface WebSetMapper {

    @Select("SELECT t.id id,t.app_id appId,t.app_name appName,t.app_gateway appGateway,t.notifyurl,t.secretKey ,u.user_name userName FROM t_appinfo t,t_user u WHERE t.user_id = u.user_id and t.user_id = #{userid}")
    List<WebSet> queryWebSet(@Param("userid") String userId);

    @Delete("delete from t_appinfo where id = #{id}")
    void deleteWebSet(@Param("id") String id);
}
