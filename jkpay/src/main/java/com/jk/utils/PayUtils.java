package com.jk.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

/**
 * Created by scc on 2018/8/23.
 */
public class PayUtils {
    /**
     * 随机生成UUID
     * @return
     */
    public static String roundUUID(){
        UUID uuid = UUID.randomUUID();
        return uuid.toString().replace("-","").toUpperCase();
    }

    /**
     * 生成AppId
     * @return
     */
    public static String generateAppId(){
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("YYYYMMdd");
        StringBuffer roundNumber = new StringBuffer(dateFormat.format(date));
        Random random = new Random();
        for (int i=0;i<8;i++){
            roundNumber.append(random.nextInt(i+3));
        }
        return roundNumber.toString();
    }

    /**
     * 生成交易流水号
     * @return
     */
    public static String generateSerialNumber(){
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("YYYYMMddHHmmss");
        StringBuffer roundNumber = new StringBuffer(dateFormat.format(date));
        Random random = new Random();
        for (int i=0;i<4;i++){
            roundNumber.append(random.nextInt(10));
        }
        return roundNumber.toString();
    }
}
