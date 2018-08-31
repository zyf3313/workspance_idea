package com.jk.mapper;

import com.jk.entity.Transaction;
import org.apache.ibatis.annotations.*;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by scc on 2018/8/24.
 */
public interface TransactionMapper {
    /**
     * 新增交易信息
     * @param transaction
     */
    @Insert("insert into t_transaction values(#{transactionId},#{serialNumber},#{outOrderId},#{orderSubject},#{totalAmount},#{transactionStatus},NOW())")
    void saveTransaction(Transaction transaction);

    @Update("update t_transaction set transaction_status = #{transactionStatus} where serial_number = #{serialNumber}")
    void updateTransactionStatus(Transaction transaction);

    @Update("update t_account set account_balance = account_balance - #{changeF2Y} where user_id = #{account}")
    void updatePersonagePrice(@Param("account") String account,@Param("changeF2Y") String changeF2Y);

    @Update("update t_account set account_balance = account_balance + #{changeF2Y} where user_id = #{account}")
    void updateAddPrice(@Param("account") String account,@Param("changeF2Y") String changeF2Y);

    @Select("select notifyurl from t_appinfo where app_id = #{appid}")
    String queryNotifyurl(@Param("appid") String appid);

    @Select("select account_balance from t_account where user_id = #{userid}")
    BigDecimal queryMoneyByUserid(@Param("userid") String userid);

    @Select("SELECT t.transaction_id transactionId FROM t_transaction t WHERE  DATE_FORMAT(t.transaction_date,'%Y%m%d') - DATE_FORMAT(NOW(),'%Y%m%d')  >7")
    List<Transaction> queryAllOverTime();

    @Select("select account_password from t_account where user_id = #{userid}")
    String queryUserPassword(@Param("userid") String userid);

    @Select("select user_id from t_appinfo where app_id = #{appid}")
    String queryUserIdByAppid(@Param("appid") String appid);

    @Select("SELECT t.out_order_id outOrderId,t.total_amount totalAmount,t.order_subject orderSubject FROM t_transaction t where t.serial_number = #{serialNumber} ")
    Transaction queryTransaction(@Param("serialNumber") String serialNumber);
}
