package com.github.entropyfeng.simpleauth.service;

import com.github.entropyfeng.simpleauth.exception.AccountNotExistException;
import com.github.entropyfeng.simpleauth.exception.PasswordErrorException;

import javax.validation.constraints.NotNull;
import java.util.List;
/**
 * @author entropyfeng
 * @date 2019/6/12 19:15
 */
public interface AuthService {
    /**
     * 在role集合中 检查是否包含相关权限
     * @param roleList 用户所具有的角色列表
     * @param perm 用户需要的权限 即 url+method
     * @return false 检查失败 true 检查成功
     */
    public boolean checkPerm(@NotNull List<String> roleList,@NotNull String perm);


    /**
     * 登录，并签发jwt
     * @param userId 用户id
     * @param password 密码
     * @return jwt string 若为null,则登录失败
     * @throws PasswordErrorException 密码没有找到异常
     * @throws AccountNotExistException 账户不存在异常
     */
    public String login(@NotNull Long userId,@NotNull String password)throws PasswordErrorException,AccountNotExistException;
}
