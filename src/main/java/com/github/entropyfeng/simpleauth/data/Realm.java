package com.github.entropyfeng.simpleauth.data;

/**
 * @author entropyfeng
 * @date 2019/7/8 19:25
 */
public interface Realm {

    /**
     * 获取当前Realm 的名称
     * @return 当前Realm 的名称
     */
    String getName();

    boolean supports(AuthenticationToken token);

    AuthenticationInfo getAuthenticationInfo();

}
