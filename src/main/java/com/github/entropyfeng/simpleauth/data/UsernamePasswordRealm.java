package com.github.entropyfeng.simpleauth.data;

import org.springframework.context.ApplicationEventPublisher;

/**
 * @author entropyfeng
 * @date 2019/7/8 19:39
 */
public class UsernamePasswordRealm extends AbstractLoginRealm{

    private UsernamePasswordInfo usernamePasswordInfo;

    public UsernamePasswordRealm(Object source) {
        super(source);
    }

    @Override
    public String getName() {
        return this.getClass().getName();
    }

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof UsernamePasswordToken;
    }

    @Override
    public AuthenticationInfo getAuthenticationInfo(AuthenticationToken token) {
        return null;
    }

}
