package com.github.entropyfeng.simpleauth.event;

import org.springframework.context.ApplicationEvent;

/**
 * @author entropyfeng
 * @date 2019/6/13 14:14
 */
public class LoadAuthDomainEvent extends ApplicationEvent {

    public LoadAuthDomainEvent(Object source) {
        super(source);


    }
    
}
