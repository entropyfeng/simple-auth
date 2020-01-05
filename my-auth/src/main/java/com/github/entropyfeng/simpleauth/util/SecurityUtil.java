package com.github.entropyfeng.simpleauth.util;

import org.springframework.util.DigestUtils;

import javax.validation.constraints.NotNull;

/**
 * @author entropyfeng
 * @date 2020/1/5 16:47
 */
public final class SecurityUtil {

    /**
     * MD5散列加盐
     * @param plain ordinary data
     * @param salt salt
     * @return after md5
     */
    public static String addSalt(@NotNull String plain, @NotNull String salt){

        //可以自定义加盐位置
      return   DigestUtils.md5DigestAsHex(((salt+plain)).getBytes());

    }
}
