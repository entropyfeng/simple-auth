package com.github.entropyfeng.simpleauth.core;

import com.github.entropyfeng.simpleauth.data.AuthenticationInfo;
import com.github.entropyfeng.simpleauth.data.AuthenticationToken;

/**
 * @author entropyfeng
 * @date 2019/7/16 22:17
 */
public interface CredentialsMatcher {

    boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info);
}
