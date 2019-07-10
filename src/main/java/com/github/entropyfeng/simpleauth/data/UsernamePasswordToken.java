package com.github.entropyfeng.simpleauth.data;

/**
 * @author entropyfeng
 * @date 2019/7/10 12:37
 */
public class UsernamePasswordToken implements AuthenticationToken {



    @Override
    public Object getPrincipal() {
        return null;
    }

    @Override
    public Object getCredential() {
        return null;
    }
}
