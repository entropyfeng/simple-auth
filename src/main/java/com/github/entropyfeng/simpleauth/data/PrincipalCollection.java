package com.github.entropyfeng.simpleauth.data;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * @author entropyfeng
 * @date 2019/7/8 19:31
 */
public interface PrincipalCollection extends Iterable, Serializable {


    Object getPrimaryPrincipal();


    <T> Collection<T> byType(Class<T> type);


    List asList();

    Set asSet();

    Collection fromRealm(String realmName);


    Set<String> getRealmNames();


    boolean isEmpty();
}
