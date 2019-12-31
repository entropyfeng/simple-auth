package com.github.entropyfeng.simpleauth.data;

/**
 * @author entropyfeng
 * @date 2019/7/8 19:33
 */
public interface AuthenticationToken {


    Object getPrincipal();

    Object getCredential();
}
