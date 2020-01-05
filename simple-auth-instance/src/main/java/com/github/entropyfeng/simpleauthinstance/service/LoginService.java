package com.github.entropyfeng.simpleauthinstance.service;

import javax.validation.constraints.NotNull;

/**
 * @author entropyfeng
 * @date 2020/1/5 16:25
 */
public interface LoginService {

    /**
     * 根据用户名密码登录
     * @param username 用户名
     * @param password 密码
     * @return token
     */
    public String loginByUsernamePassword(@NotNull String username,@NotNull String password);

    /**
     * 根据用户名密码登录(加密)
     * @param username 用户名
     * @param password 密码
     * @return token
     */
    public String loginByUsernamePasswordEncrypt(@NotNull String username,@NotNull String password);
}
