package com.jk.utils;

import com.jk.constant.TransactionConstant;
import com.jk.entity.Transaction;
import com.jk.mapper.TransactionMapper;

import java.util.List;

/**
 * @创建人 yangfan zhang
 * @创建时间 2018/8/26 22:23
 * @描述
 */
public class RunnablePool implements Runnable{

    private TransactionMapper transactionMapper;
    private Transaction  transaction;

    public RunnablePool() {
    }

    public RunnablePool(TransactionMapper transactionMapper, Transaction transaction) {
        this.transactionMapper = transactionMapper;
        this.transaction = transaction;
    }

    @Override
    public void run() {
        transaction.setTransactionStatus(TransactionConstant.TRANSACTION_STATUS_CLOSE);
        transactionMapper.updateTransactionStatus(transaction);
    }
}
