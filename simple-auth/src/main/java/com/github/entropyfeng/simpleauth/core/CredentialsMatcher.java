package com.github.entropyfeng.simpleauth.core;

import com.github.entropyfeng.simpleauth.data.AuthenticationInfo;
import com.github.entropyfeng.simpleauth.data.AuthenticationToken;

/**
 * 凭证匹配器
 * @author entropyfeng
 * @date 2019/7/16 22:17
 */
public interface CredentialsMatcher {

    /**
     *
     * @param token {@link AuthenticationToken}
     * @param info {@link AuthenticationInfo }
     * @return true-> match successfully
     *         false->match fail
     */
    boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info);
}
