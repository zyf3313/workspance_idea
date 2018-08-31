package com.jk.service;

import com.jk.entity.Transaction;

/**
 * Created by scc on 2018/8/24.
 */
public interface OpenPayService {
    void addTransaction(Transaction transaction);

    void updateTransactionStatus(Transaction transaction);

    void updatePay(String appid, String changeF2Y);

    String queryNotifyurl(String appid);

    String passwordEstimate(String userid);

    Transaction queryTransaction(String serialNumber);

    String passwordVerify(String password,String appid);
}
