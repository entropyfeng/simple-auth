package com.github.entropyfeng.simpleauth.data;

import org.springframework.context.ApplicationEventPublisher;

/**
 * @author entropyfeng
 * @date 2019/7/8 19:39
 */
public class UsernamePasswordRealm extends AbstractLoginRealm{

    private UsernamePasswordInfo usernamePasswordInfo;

    private UsernamePasswordToken usernamePasswordToken;

    public UsernamePasswordRealm(Object source,UsernamePasswordToken usernamePasswordToken) {
        super(source);
        this.usernamePasswordToken=usernamePasswordToken;
    }

    @Override
    public String getName() {
        return this.getClass().getName();
    }

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof UsernamePasswordToken;
    }


    public UsernamePasswordToken getUsernamePasswordToken() {
        return usernamePasswordToken;
    }

    @Override
    public AuthenticationInfo getAuthenticationInfo()
    {
        return usernamePasswordInfo;
    }

    public void setUsernamePasswordInfo(UsernamePasswordInfo usernamePasswordInfo) {
        this.usernamePasswordInfo = usernamePasswordInfo;
    }
}
