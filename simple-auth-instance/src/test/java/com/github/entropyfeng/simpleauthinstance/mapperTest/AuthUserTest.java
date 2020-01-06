package com.github.entropyfeng.simpleauthinstance.mapperTest;

import com.alibaba.fastjson.JSON;
import com.github.entropyfeng.simpleauthinstance.dao.AuthUserMapper;
import com.github.entropyfeng.simpleauthinstance.domain.bo.AuthUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.*;

/**
 * @author entropyfeng
 * @date 2020/1/6 12:48
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AuthUserTest {

    @Autowired
    AuthUserMapper authUserMapper;

    @Test
    public void testUpdatePassword(){
        authUserMapper.updatePasswordByUserId(3,"testId3");
    }

    @Test
    public void testInsertAuthUser(){
        AuthUser authUser=new AuthUser("狗群主","789");
        authUser.setUserId(10);
        authUserMapper.insertAuthUser(authUser);
    }

    @Test
    public void testPrimaryKeyException(){
        AuthUser authUser=new AuthUser("猫群主","789");
        authUser.setUserId(1);
        try {
            authUserMapper.insertAuthUser(authUser);
        }catch (DuplicateKeyException e){

            e.printStackTrace();
        }

    }

    @Test
    public void testSelectPasswordByUsername(){

       String res= authUserMapper.selectPasswordByUsername("admin");

        System.out.println(res);
    }
    @Test
    public void testSelectAuthUserByUserId(){

        AuthUser authUser=authUserMapper.selectAuthUserByUserId(1);
        System.out.println(JSON.toJSONString(authUser));
    }

    @Test
    public void testUserAndItsRole(){

      List list=  authUserMapper.selectRolesByUid(1);
        System.out.println(JSON.toJSONString(list));
    }
}
