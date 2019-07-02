package com.github.entropyfeng.simpleauth.service;

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

    public String login(String userId,String password);
}
