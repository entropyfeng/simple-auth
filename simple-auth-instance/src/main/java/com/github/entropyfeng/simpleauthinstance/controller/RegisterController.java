package com.github.entropyfeng.simpleauthinstance.controller;

import com.github.entropyfeng.simpleauthinstance.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author entropyfeng
 * @date 2020/1/5 16:37
 */
@RestController
public class RegisterController {


    @Autowired
    private RegisterService registerService;

    /**
     * 根据用户名密码注册新用户
     * @param username 用户名
     * @param password 密码
     * @return {@link com.github.entropyfeng.simpleauth.data.vo.Message}
     */
    @RequestMapping("/register/up")
    public String registerByUsernamePassword(String username,String password){



        return null;

    }
}
