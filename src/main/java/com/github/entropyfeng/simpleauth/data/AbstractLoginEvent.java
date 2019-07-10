package com.github.entropyfeng.simpleauth.data;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.context.ApplicationEvent;

/**
 * @author entropyfeng
 * @date 2019/7/10 12:55
 */
public abstract class AbstractLoginEvent extends ApplicationEvent {

    private AuthenticationToken authenticationToken;
    private AuthenticationInfo authenticationInfo;
    public  AbstractLoginEvent(Object source, AuthenticationToken authenticationToken, AuthenticationInfo authenticationInfo) {
        super(source);
        this.authenticationToken=authenticationToken;
        this.authenticationInfo=authenticationInfo;
    }

    public AuthenticationInfo getAuthenticationInfo() {
        return authenticationInfo;
    }

    public void setAuthenticationInfo(AuthenticationInfo authenticationInfo) {
        this.authenticationInfo = authenticationInfo;
    }

    public AuthenticationToken getAuthenticationToken() {
        return authenticationToken;
    }

    public void setAuthenticationToken(AuthenticationToken authenticationToken) {
        this.authenticationToken = authenticationToken;
    }
}
