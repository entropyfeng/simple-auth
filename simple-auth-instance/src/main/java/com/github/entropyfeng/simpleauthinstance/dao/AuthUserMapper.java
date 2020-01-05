package com.github.entropyfeng.simpleauthinstance.dao;

import org.apache.ibatis.annotations.Mapper;

/**
 * @author entropyfeng
 * @date 2020/1/5 16:31
 */
@Mapper
public interface AuthUserMapper {

    /**
     * 根据用户名查找密码
     * @param username 用户名
     * @return 密码
     */
    String selectPasswordByUsername(String username);


}
