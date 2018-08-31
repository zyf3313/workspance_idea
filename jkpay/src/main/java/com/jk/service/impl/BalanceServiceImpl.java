package com.jk.service.impl;

import com.jk.mapper.BalanceMapper;
import com.jk.service.BalanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by scc on 2018/8/23.
 */
@Service
public class BalanceServiceImpl  implements BalanceService {
    @Autowired
    private BalanceMapper balanceMapper;
    @Override
    public Long queryBalance() {
        return balanceMapper.queryBalanceByUserId("C7944823356E45C88D112415938FE066");
    }
}
