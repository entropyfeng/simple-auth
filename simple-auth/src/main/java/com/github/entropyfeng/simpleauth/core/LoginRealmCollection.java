package com.github.entropyfeng.simpleauth.core;

import com.github.entropyfeng.simpleauth.data.AbstractLoginRealm;
import com.github.entropyfeng.simpleauth.data.Realm;
import java.util.List;
/**
 * @author entropyfeng
 * @date 2019/7/12 20:42
 */
public interface LoginRealmCollection {

    public List<AbstractLoginRealm> getRealms();

    public void addRealm(AbstractLoginRealm  realm);

    public void addAllRealm(List<AbstractLoginRealm> realms);

    public void removeRealm(String realmName);

    public void removeRealm(AbstractLoginRealm realm);



}
