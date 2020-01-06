package com.github.entropyfeng.simpleauthinstance.dao;

import com.github.entropyfeng.simpleauthinstance.domain.bo.AuthUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.*;
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
    String selectPasswordByUsername(@Param("username") String username);

    /**
     * 根据userId 查询authUser实体
     * @param userId 用户Id
     * @return {@link AuthUser}
     */
    AuthUser selectAuthUserByUserId(@Param("userId")int userId);

    /**
     * 根据username 查询authUser实体
     * @param username 用户名
     * @return {@link AuthUser}
     */
   AuthUser selectAuthUserByUsername(@Param("username")String username);

    /**
     * 插入AuthUser实体
     * @param authUser {@link AuthUser}
     * @return the row numbers affected
     */
    int insertAuthUser(@Param("authUser") AuthUser authUser);


    /**
     * 根据userId更新密码
     * @param userId int用户名
     * @param password String 密码
     * @return the row numbers affected
     */
    int updatePasswordByUserId(@Param("userId") int userId,@Param("password") String password);


    /**
     * 在数据库中查询该username的数量
     * @param username 用户名
     * @return username的数量
     */
    int selectCountUsername(@Param("username") String username);

    /**
     * 在数据库中查询该phone的数量
     * @param phone 手机
     * @return phone的数量
     */
    int selectCountPhone(@Param("phone") String phone);

    /**
     * 在数据库中查询该email的数量
     * @param email 邮箱
     * @return email 的数量
     */
    int selectCountEmail(@Param("email") String email);


    /**
     * 根据userId查询其包含的角色
     * @param userId 用户Id
     * @return roleName collection
     */
    List<String> selectRolesByUid(@Param("userId")int userId);

}
