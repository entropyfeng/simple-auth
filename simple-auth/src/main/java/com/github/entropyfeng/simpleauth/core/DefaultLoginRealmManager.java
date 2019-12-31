package com.github.entropyfeng.simpleauth.core;

import com.github.entropyfeng.simpleauth.data.AbstractLoginRealm;
import com.github.entropyfeng.simpleauth.data.Realm;

import java.util.LinkedList;
import java.util.List;

/**
 * @author entropyfeng
 * @date 2019/7/12 20:52
 */
public class DefaultLoginRealmManager implements LoginRealmCollection {
    private List<AbstractLoginRealm> realmList=new LinkedList<>();

    public DefaultLoginRealmManager(List<AbstractLoginRealm> realmList) {
        this.realmList = realmList;
    }

    @Override
    public List<AbstractLoginRealm> getRealms() {

        return realmList;
    }

    @Override
    public void addRealm(AbstractLoginRealm realm) {
        realmList.add(realm);
    }

    @Override
    public void addAllRealm(List<AbstractLoginRealm> realms) {

        realmList.addAll(realms);
    }


    @Override
    public synchronized  void removeRealm(String realmName) {


    }

    @Override
    public void removeRealm(AbstractLoginRealm realm) {

        realmList.remove(realm);
    }
}
