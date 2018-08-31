package com.jk.mapper;

import org.apache.ibatis.annotations.Select;

/**
 * Created by scc on 2018/8/23.
 */
public interface BalanceMapper {
    /**
     * 根据用户id查询当前用余额
     * @param userId
     * @return
     */
    @Select("select account_balance from t_account where user_id = #{userId}")
    Long queryBalanceByUserId(String userId);
}
