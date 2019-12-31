package com.github.entropyfeng.simpleauth.config;

import com.github.entropyfeng.simpleauth.core.LoginRealmCollection;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @author entropyfeng
 * @date 2019/7/12 20:44
 */
@Component
public class RealmConfiguration {

    private LoginRealmCollection loginRealmCollection;



    public void setRealmManager(LoginRealmCollection loginRealmCollection) {
        this.loginRealmCollection = loginRealmCollection;
    }

    public LoginRealmCollection getLoginRealmCollection() {
        return loginRealmCollection;
    }

    public void reloadRealm(){

    }

}
