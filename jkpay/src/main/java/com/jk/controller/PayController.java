package com.jk.controller;

import com.jk.service.BalanceService;
import com.jk.utils.AmountUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;

/**
 * Created by scc on 2018/8/22.
 */
@Controller
@RequestMapping("pay/account")
public class PayController {

    @Autowired
    private BalanceService balanceService;

    @RequestMapping("recharge")
    public void rechargeBalance(){

    }
    @RequestMapping("queryBalance")
    @ResponseBody
    public String queryBalance(){
        Long balance = balanceService.queryBalance();
        String myBalance = null;
        try {
            myBalance = AmountUtils.changeF2Y(balance.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return myBalance;
    }
}
