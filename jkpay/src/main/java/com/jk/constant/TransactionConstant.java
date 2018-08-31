package com.jk.constant;

/**
 * Created by scc on 2018/8/24.
 */
public class TransactionConstant {
    /** 交易状态 打开交易*/
    public static final int TRANSACTION_STATUS_OPEN = 1;
    /** 交易状态 确认交易*/
    public static final int TRANSACTION_STATUS_CONFIRM = 2;
    /** 交易状态 交易成功*/
    public static final int TRANSACTION_STATUS_SUCCESS = 3;
    /** 交易状态 交易失败*/
    public static final int TRANSACTION_STATUS_FAIL = 4;
    /** 交易状态 交易关闭*/
    public static final int TRANSACTION_STATUS_CLOSE = 5;
}
