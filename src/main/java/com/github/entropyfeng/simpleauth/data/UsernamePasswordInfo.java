package com.github.entropyfeng.simpleauth.data;

/**
 * @author entropyfeng
 * @date 2019/7/10 13:20
 */
public class UsernamePasswordInfo implements AuthenticationInfo {
    @Override
    public Object getPrincipal() {
        return null;
    }

    @Override
    public Object getCredential() {
        return null;
    }
}
