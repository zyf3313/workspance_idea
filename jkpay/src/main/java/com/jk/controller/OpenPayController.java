package com.jk.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jk.constant.TransactionConstant;
import com.jk.entity.Transaction;
import com.jk.service.OpenPayService;
import com.jk.utils.AESUtil;
import com.jk.utils.AmountUtils;
import com.jk.utils.PayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by scc on 2018/8/24.
 */
@Controller
public class OpenPayController {
    @Autowired
    private OpenPayService openPayService;

    @RequestMapping("/gateWay")
    @ResponseBody
    public String gateWay(String param, HttpServletRequest request) {

        String secretkey = request.getHeader("secretkey");
        String params = AESUtil.decrypt(param, secretkey);

        Transaction transaction = JSON.parseObject(params, Transaction.class);
        System.out.println(transaction);
        transaction.setTransactionId(PayUtils.roundUUID());//交易id
        String serialNumber = PayUtils.generateSerialNumber();
        transaction.setSerialNumber(serialNumber);//流水号
        transaction.setTransactionStatus(TransactionConstant.TRANSACTION_STATUS_OPEN);//交易状态
        Map<String, String> resultMap = new HashMap<String, String>();
        try {
            transaction.setTotalAmount(AmountUtils.changeF2Y(transaction.getTotalAmount()));//交易金钱
            openPayService.addTransaction(transaction);//添加交易流水账
            String url = openPayService.queryNotifyurl(transaction.getAppid());
            resultMap.put("serialNumber", serialNumber);
            resultMap.put("payStatus", "1");
            resultMap.put("notifyurl", url);
            resultMap.put("url","http://192.168.1.152:8080/toPayCenter");
            resultMap.put("massage", "交易成功");
        } catch (Exception e) {
            resultMap.put("payStatus", "2");
            resultMap.put("massage", "交易失败");
            transaction.setTransactionStatus(TransactionConstant.TRANSACTION_STATUS_FAIL);//交易失败
            openPayService.updateTransactionStatus(transaction);
        }
        String result = AESUtil.encrypt(JSON.toJSONString(resultMap),secretkey);
        return result;
    }

    /**
     * 支付页面
     * @param model
     * @return
     */
    @RequestMapping("toPayCenter")
    public String toPayCenter(String header,String body,Model model){
        String secretkey = header;
        String param = AESUtil.decrypt(body, secretkey);
        Map<String,String> bodyValue = JSON.parseObject(param,HashMap.class);
        String serialNumber = bodyValue.get("serialNumber");
        String appid = bodyValue.get("appid");
        Transaction transaction = openPayService.queryTransaction(serialNumber);
        model.addAttribute("serialNumber",serialNumber);
        model.addAttribute("orderid",transaction.getOutOrderId());
        model.addAttribute("amount",transaction.getTotalAmount());
        model.addAttribute("shopinfo",transaction.getOrderSubject());
        model.addAttribute("appid",appid);
        return "payCenter";
    }

    /**
     * 判断支付密码
     * @return
     */
    @RequestMapping("/passwordVerify")
    @ResponseBody
    public JSONObject passwordVerify(String password, String serialNumber, String totalAmount, String appid){
        String flag = openPayService.passwordVerify(password,appid);
        Transaction transaction = new Transaction();
        transaction.setSerialNumber(serialNumber);
        transaction.setTotalAmount(totalAmount);
        transaction.setAppid(appid);
        transaction.setTransactionStatus(TransactionConstant.TRANSACTION_STATUS_CONFIRM);//确认交易
        openPayService.updateTransactionStatus(transaction);
        JSONObject json = new JSONObject();
        if(flag.equals("1")){
            openPayService.updatePay(transaction.getAppid(), transaction.getTotalAmount());//扣除金钱
            transaction.setTransactionStatus(TransactionConstant.TRANSACTION_STATUS_SUCCESS);//交易成功
            openPayService.updateTransactionStatus(transaction);
            String url = openPayService.queryNotifyurl(appid);
            json.put("url",url);
        }
        json.put("flag",flag);
        return json;
    }

}
