package com.github.entropyfeng.simpleauth.config.anno;

import java.lang.annotation.*;

/**
 * @author entropyfeng
 * @date 2019/6/12 15:40
 */
//用来注解类
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LoginAuth {

    String loginMethod();

}
