package com.github.entropyfeng.simpleauth.service;

/**
 * @author entropyfeng
 * @date 2020/1/5 17:02
 */
public interface IDService {

    /**
     * 获取全局唯一的userId
     * @return userId
     */
    public int getGlobalUniqueId();

    /**
     * 获取全局唯一roleId
     * @return roleId
     */
    public int getGlobalRoleId();

    /**
     * 获取全局唯一resourceId
     * @return resourceId
     */
    public int getGlobalResourceId();
}
