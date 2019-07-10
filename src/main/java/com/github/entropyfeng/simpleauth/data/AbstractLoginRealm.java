package com.github.entropyfeng.simpleauth.data;

import org.springframework.context.ApplicationEventPublisher;

/**
 * @author entropyfeng
 * @date 2019/7/10 12:45
 */

public abstract class AbstractLoginRealm implements Realm {

    private  ApplicationEventPublisher eventPublisher;

    private AbstractLoginEvent abstractLoginEvent;


    /**
     * 获取当前Realm名称
     * @return 当前Realm名称
     */
    @Override
    public abstract String getName();


    /**
     * 该realm是否支持此token
     * @param token {@link AuthenticationToken}
     * @return false 不支持 true 支持
     */
    @Override
    public abstract boolean  supports(AuthenticationToken token);



    public void setAbstractLoginEvent(AbstractLoginEvent abstractLoginEvent) {
        this.abstractLoginEvent = abstractLoginEvent;
    }

    @Override
    public AuthenticationInfo getAuthenticationInfo(AuthenticationToken token) {

        abstractLoginEvent.setAuthenticationToken(token);
        eventPublisher.publishEvent(abstractLoginEvent);
        return abstractLoginEvent.getAuthenticationInfo();
    }

    public void setEventPublisher(ApplicationEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

}
