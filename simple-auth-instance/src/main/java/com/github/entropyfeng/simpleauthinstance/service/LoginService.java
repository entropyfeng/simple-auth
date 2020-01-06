package com.github.entropyfeng.simpleauthinstance.service;

import com.github.entropyfeng.simpleauth.exception.AccountNotExistException;
import com.github.entropyfeng.simpleauth.exception.PasswordErrorException;

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
     * @throws PasswordErrorException 密码错误异常
     * @throws AccountNotExistException 账户不存在异常
     */
    public String loginByUsernamePassword(@NotNull String username,@NotNull String password)throws PasswordErrorException,AccountNotExistException;

    /**
     * 根据用户名密码登录(加密)
     * @param username 用户名
     * @param password 密码
     * @return token
     */
    public String loginByUsernamePasswordEncrypt(@NotNull String username,@NotNull String password);
}
