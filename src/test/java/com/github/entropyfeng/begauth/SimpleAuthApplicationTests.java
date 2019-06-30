package com.github.entropyfeng.begauth;

import com.github.entropyfeng.begauth.service.AuthService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SimpleAuthApplicationTests {

    @Autowired
    AuthService authService;
    @Test
    public void contextLoads() {

        authService.login("d","d");

    }

}
