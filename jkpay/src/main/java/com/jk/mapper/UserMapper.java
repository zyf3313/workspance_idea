package com.jk.mapper;

import com.jk.entity.User;
import org.apache.ibatis.annotations.*;

/**
 * Created by scc on 2018/8/23.
 */
public interface UserMapper {
    /**
     * 新增用户数据
     * @param user
     */
    @Insert("insert into t_user values(#{userId},#{userName},#{userPassword},#{userRealName})")
    void saveUser(User user);
    @Select("select * from t_user where user_name=#{userName}")
    @Results({
            @Result(id=true,column = "user_id",property = "userId"),
            @Result(column = "user_name",property = "userName"),
            @Result(column = "user_realname",property = "userRealName"),
            @Result(column = "user_password",property = "userPassword")
            })
    User queryUserByUserName(String userName);
}
