package com.github.entropyfeng.simpleauthinstance.controller;

import com.alibaba.fastjson.JSON;
import com.github.entropyfeng.simpleauth.data.vo.Message;
import com.github.entropyfeng.simpleauthinstance.service.RegisterService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping("/register/up")
    public String registerByUsernamePassword(@RequestParam("username") String username,@Param("password") String password){
        registerService.registerByUsernamePassword(username, password);
        return null;
    }



    @GetMapping("/register/checkUsername")
    public String checkUsername(@RequestParam("username")String username){



        Message message=new Message();
        if(registerService.checkDuplicateUsername(username)){
            message.setSuccess(true);
        }else {
            message.setSuccess(false);
        }
        return JSON.toJSONString(message);

    }

    @GetMapping("/register/checkPhone")
    public String checkPhone(@RequestParam("phone")String phone){

        Message message=new Message();
        if(registerService.checkDuplicatePhone(phone)){
            message.setSuccess(true);
        }else {
            message.setSuccess(false);
        }
        return JSON.toJSONString(message);
    }
    @GetMapping("/register/checkEmail")
    public String checkEmail(@RequestParam("email")String email){

        Message message=new Message();
        if(registerService.checkDuplicateEmail(email)){
            message.setSuccess(true);
        }else {
            message.setSuccess(false);
        }
        return JSON.toJSONString(message);
    }
}
