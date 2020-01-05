package com.github.entropyfeng.simpleauthinstance.controller;

import com.alibaba.fastjson.JSON;
import com.github.entropyfeng.simpleauth.config.anno.PostAuth;
import com.github.entropyfeng.simpleauth.data.vo.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author entropyfeng
 * @date 2020/1/5 16:11
 */
@RestController
public class LoginController {

    private static final Logger logger=LoggerFactory.getLogger(LoginController.class);

    @PostMapping("/login/up")
    public String login(@RequestParam("username")String username,@RequestParam("password") String password ){

        Message message=new Message();
        logger.info("username -> {} ; password->{}",username,password);
        return JSON.toJSONString(message);
    }

    @PostMapping("/testPost")
    @PostAuth("/testPost")
    public String testPost(){

        return null;
    }

}
