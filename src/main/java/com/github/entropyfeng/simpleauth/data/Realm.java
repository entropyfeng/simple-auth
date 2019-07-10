package com.github.entropyfeng.simpleauth.data;

/**
 * @author entropyfeng
 * @date 2019/7/8 19:25
 */
public interface Realm {

    String getName();

    boolean supports(AuthenticationToken token);

    AuthenticationInfo getAuthenticationInfo(AuthenticationToken token);

}
