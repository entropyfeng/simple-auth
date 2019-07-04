package com.github.entropyfeng.simpleauth;

import com.github.entropyfeng.simpleauth.service.AuthService;
import com.github.entropyfeng.simpleauth.util.SpringUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SimpleAuthApplicationTests {


    @Test
    public void contextLoads() {

        AuthService authService= (AuthService) SpringUtil.getBean("authService");
        authService.toString();


    }

}
