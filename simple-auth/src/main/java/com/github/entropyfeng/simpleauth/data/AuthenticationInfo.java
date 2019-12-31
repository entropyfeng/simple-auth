package com.github.entropyfeng.simpleauth.data;

import java.io.Serializable;

/**
 * @author entropyfeng
 * @date 2019/7/8 19:29
 */
public interface AuthenticationInfo extends Serializable {

    Object getPrincipal();

    Object getCredential();
}
