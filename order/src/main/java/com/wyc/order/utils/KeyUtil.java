package com.wyc.order.utils;

import java.util.Random;

/**
 * @author: wyc
 * @date: 2018/11/25
 */
public class KeyUtil {

    public static synchronized String genUniqueKey(){
        Random random = new Random();
        Integer number = random.nextInt(900000) + 100000;
        return System.currentTimeMillis() + String.valueOf(number);
    }
}
