package com.github.entropyfeng.simpleauth.event;

import org.springframework.context.ApplicationEvent;

/**
 * @author entropyfeng
 * @date 2019/12/26 17:09
 */
public class LoadUidEvent extends ApplicationEvent {


    public LoadUidEvent(Object source) {
        super(source);
    }
}
