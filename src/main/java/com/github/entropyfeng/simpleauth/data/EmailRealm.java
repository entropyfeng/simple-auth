package com.github.entropyfeng.simpleauth.data;

/**
 * @author entropyfeng
 * @date 2019/7/16 22:26
 */
public class EmailRealm extends AbstractLoginRealm {
    private EmailToken emailToken;
    private EmailInfo emailInfo;

    public EmailRealm(Object source) {
        super(source);
    }

    @Override
    public String getName() {
        return this.getClass().getName();
    }

    @Override
    public boolean supports(AuthenticationToken token) {

        return token instanceof EmailToken;
    }

    @Override
    public AuthenticationInfo getAuthenticationInfo() {

        return emailInfo;
    }
}
