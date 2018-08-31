package com.jk.service.impl;

import com.jk.entity.Transaction;
import com.jk.entity.User;
import com.jk.mapper.TransactionMapper;
import com.jk.service.OpenPayService;
import com.jk.utils.RunnablePool;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by scc on 2018/8/24.
 */
@Service
@EnableScheduling
public class OpenPayServiceImpl implements OpenPayService{

    @Autowired
    private TransactionMapper transactionMapper;

    @Override
    public void addTransaction(Transaction transaction) {

        transactionMapper.saveTransaction(transaction);
    }

    @Override
    public void updateTransactionStatus(Transaction transaction) {
        transactionMapper.updateTransactionStatus(transaction);
    }

    @Override
    public void updatePay(String appid, String changeF2Y) {
        String userid = transactionMapper.queryUserIdByAppid(appid);
        BigDecimal money = transactionMapper.queryMoneyByUserid(userid);
        int a = money.compareTo(BigDecimal.valueOf(Double.parseDouble(changeF2Y)));
        if(a == 0 || a == 1 ) {
            transactionMapper.updatePersonagePrice(userid, changeF2Y);//首先减去个人金额
            userid = "C7944823356E45C88D112415938FE066";
            transactionMapper.updateAddPrice(userid, changeF2Y);
        }else{
            new Exception();
        }
    }

    @Override
    public String queryNotifyurl(String appid) {
        return transactionMapper.queryNotifyurl(appid);
    }

    @Override
    public String passwordEstimate(String userId) {
        String accountPassword = transactionMapper.queryUserPassword(userId);
        return accountPassword;
    }

    @Override
    public Transaction queryTransaction(String serialNumber) {

        return transactionMapper.queryTransaction(serialNumber);
    }

    @Override
    public String passwordVerify(String password,String appid) {
        String userid = transactionMapper.queryUserIdByAppid(appid);
        String accountPassword = transactionMapper.queryUserPassword(userid);
        if(password.equals(accountPassword)){
            return "1";
        }else{
            return "2";
        }
    }

    @Scheduled(cron = "0 0 12 * * ?")
    public void timer(){
        List<Transaction> list = transactionMapper.queryAllOverTime();
        ExecutorService threadPool = Executors.newFixedThreadPool(20);
        for (int i = 0;i<list.size();i++){
            threadPool.execute(new RunnablePool(transactionMapper,list.get(i)));
        }
    }
}
