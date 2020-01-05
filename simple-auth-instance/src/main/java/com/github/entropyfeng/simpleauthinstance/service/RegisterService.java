package com.github.entropyfeng.simpleauthinstance.service;

import javax.validation.constraints.NotNull;

/**
 * @author entropyfeng
 * @date 2020/1/5 16:39
 */
public interface RegisterService {

    /**
     * 根据用户名密码创建账户
     * @param username 用户名
     * @param password 密码
     * @return true->注册成功
     *         false->注册失败
     */
    public boolean registerByUsernamePassword(@NotNull String username, @NotNull String password);


}
