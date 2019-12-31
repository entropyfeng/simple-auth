package com.github.entropyfeng.simpleauth.data;

/**
 * @author entropyfeng
 * @date 2019/7/10 12:37
 */
public class UsernamePasswordToken implements AuthenticationToken {


    private String username;
    private String password;

    public UsernamePasswordToken(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public Object getPrincipal() {
        return username;
    }

    @Override
    public Object getCredential() {
        return password;
    }
}
