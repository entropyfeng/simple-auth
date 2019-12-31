package com.github.entropyfeng.simpleauth.data;

import com.github.entropyfeng.simpleauth.data.status.PrincipalStatus;

/**
 * @author entropyfeng
 * @date 2019/7/10 13:20
 */
public class UsernamePasswordInfo implements AuthenticationInfo {


    public UsernamePasswordInfo(String username, String password, PrincipalStatus principalStatus) {
        this.username = username;
        this.password = password;
        this.principalStatus = principalStatus;
    }

    private String username;
    private String password;
    private PrincipalStatus principalStatus;
    @Override
    public Object getPrincipal() {
        return username;
    }

    @Override
    public Object getCredential() {
        return password;
    }

    public PrincipalStatus getPrincipalStatus() {
        return principalStatus;
    }
}
