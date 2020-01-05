package com.github.entropyfeng.simpleauth.event;

import org.springframework.context.ApplicationEvent;

/**
 * 加载RBAC信息进入到Redis事件
 * @author entropyfeng
 * @date 2019/6/13 14:14
 */
public class LoadAuthDomainEvent extends ApplicationEvent {

    public LoadAuthDomainEvent(Object source) {
        super(source);
    }
    
}
