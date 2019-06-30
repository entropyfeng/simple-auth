package com.github.entropyfeng.begauth.util;

import java.util.UUID;

/**
 * @author entropyfeng
 * @date 2019/6/9 21:35
 */
public class CommonUtil {
    /**
     * 获得kaptcha 的token
     * 在分布式情况下可能导致未定义的结果
     * @return kaptchaToken
     */
    public static String getKaptchaToken(){

        return UUID.randomUUID().toString();

    }


}
