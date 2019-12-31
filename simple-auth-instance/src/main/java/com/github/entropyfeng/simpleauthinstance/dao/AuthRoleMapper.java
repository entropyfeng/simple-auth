package com.github.entropyfeng.simpleauthinstance.dao;

import com.github.entropyfeng.simpleauthinstance.domain.vo.RolesAndItsResources;
import org.apache.ibatis.annotations.Mapper;
import java.util.*;
/**
 * @author entropyfeng
 * @date 2019/12/31 15:13
 */
@Mapper
public interface AuthRoleMapper {

    /**
     * 查询所有roles
     * @return {@link com.github.entropyfeng.simpleauthinstance.domain.bo.AuthRole}的集合
     */
    public List selectAllRoles();

    public List<RolesAndItsResources> selectAllRolesAndItsResources();
}
