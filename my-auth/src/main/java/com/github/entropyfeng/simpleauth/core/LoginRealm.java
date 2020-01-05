package com.github.entropyfeng.simpleauth.core;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author entropyfeng
 * @date 2019/12/30 18:07
 */
public interface LoginRealm {

    /**
     *
     * @param request {@link HttpServletRequest}
     * @param response {@link HttpServletResponse}
     * @return true->pass the interceptor
     *         false->terminate the interceptor
     */
    public boolean doMatch(HttpServletRequest request, HttpServletResponse response);
}
