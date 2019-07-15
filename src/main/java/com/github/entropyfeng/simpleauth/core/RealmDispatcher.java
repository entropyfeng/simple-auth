package com.github.entropyfeng.simpleauth.core;

import com.github.entropyfeng.simpleauth.config.RealmConfiguration;
import com.github.entropyfeng.simpleauth.data.AbstractLoginRealm;
import com.github.entropyfeng.simpleauth.data.AuthenticationToken;
import com.github.entropyfeng.simpleauth.data.Realm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

/**
 * @author entropyfeng
 * @date 2019/7/12 17:47
 */
@Component
public class RealmDispatcher {


    public RealmConfiguration realmConfiguration;

    private ApplicationEventPublisher eventPublisher;
    @Autowired
    public RealmDispatcher(RealmConfiguration realmConfiguration, ApplicationEventPublisher eventPublisher) {
        this.realmConfiguration = realmConfiguration;
        this.eventPublisher = eventPublisher;
    }

    public boolean dispatcher(AuthenticationToken authenticationToken){
        for (AbstractLoginRealm realm: realmConfiguration.getLoginRealmCollection().getRealms()){
            if (realm.supports(authenticationToken)){
                eventPublisher.publishEvent(realm);
                
                return true;
            }
        }
        return false;
    }
}
