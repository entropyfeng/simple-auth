package com.github.entropyfeng.simpleauth.data;

/**
 * @author entropyfeng
 * @date 2019/7/16 22:27
 */
public class EmailInfo implements AuthenticationInfo {
    private String email;
    private String token;

    public EmailInfo(String email, String token) {
        this.email = email;
        this.token = token;
    }

    @Override
    public Object getPrincipal() {
        return email;
    }

    @Override
    public Object getCredential() {
        return token;
    }
}
