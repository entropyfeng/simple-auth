package com.github.entropyfeng.simpleauthinstance;

import com.alibaba.fastjson.JSON;
import com.github.entropyfeng.simpleauthinstance.dao.AuthRoleMapper;
import com.github.entropyfeng.simpleauthinstance.domain.bo.AuthRole;
import java.util.*;

import com.github.entropyfeng.simpleauthinstance.domain.vo.RolesAndItsResources;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SimpleAuthInstanceApplicationTests {


    @Autowired
    AuthRoleMapper authRoleMapper;

    @Test
    public void test(){


       List<RolesAndItsResources> rolesAndItsResources= authRoleMapper.selectAllRolesAndItsResources();

      String s =JSON.toJSONString(rolesAndItsResources);
        System.out.println(s);
    }

}
