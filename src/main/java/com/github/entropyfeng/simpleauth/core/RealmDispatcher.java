package com.github.entropyfeng.simpleauth.core;

import com.github.entropyfeng.simpleauth.data.AuthenticationToken;
import com.github.entropyfeng.simpleauth.data.Realm;
import org.springframework.context.ApplicationEventPublisher;

import java.util.LinkedList;
import java.util.List;
/**
 * @author entropyfeng
 * @date 2019/7/12 17:47
 */
public class RealmDispatcher {

    private ApplicationEventPublisher eventPublisher;
    private List<Realm> realmList=new LinkedList<>();

    public void addRealm(Realm realm){
        this.realmList.add(realm);
    }

    public boolean dispatcher(AuthenticationToken authenticationToken){
        for (Realm realm: realmList){
            if (realm.supports(authenticationToken)){
                eventPublisher.publishEvent();

                return true;
            }
        }
        return false;
    }
}
