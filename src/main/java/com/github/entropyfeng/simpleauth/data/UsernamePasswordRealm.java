package com.github.entropyfeng.simpleauth.data;

import org.springframework.context.ApplicationEventPublisher;

/**
 * @author entropyfeng
 * @date 2019/7/8 19:39
 */
public class UsernamePasswordRealm extends AbstractLoginRealm{


    @Override
    public String getName() {
        return this.getClass().getSimpleName();
    }

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof UsernamePasswordToken;
    }

}
