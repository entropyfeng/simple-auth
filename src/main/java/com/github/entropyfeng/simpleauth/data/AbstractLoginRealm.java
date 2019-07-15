package com.github.entropyfeng.simpleauth.data;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;

/**
 * @author entropyfeng
 * @date 2019/7/10 12:45
 */

public abstract class AbstractLoginRealm extends ApplicationEvent implements Realm {





    public AbstractLoginRealm(Object source) {
        super(source);
    }


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



    @Override
    public abstract AuthenticationInfo getAuthenticationInfo();




}
