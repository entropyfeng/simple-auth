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


    /**
     * 查询数据库是否存在相同username
     * @param username 用户名
     * @return true->没有相同参数
     *         false->存在相同参数
     */
    public boolean checkDuplicateUsername(@NotNull String username);


    /**
     * 查询数据库是否存在相同phone
     * @param phone 电话
     * @return true->没有相同参数
     *         false->存在相同参数
     */
    public boolean checkDuplicatePhone(@NotNull String phone);

    /**
     * 查询数据库是否存在相同email
     * @param email 邮箱
     * @return true->没有相同参数
     *         false->存在相同参数
     */
    public boolean checkDuplicateEmail(@NotNull String email);

}
