package com.github.entropyfeng.simpleauth.config.anno;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.lang.annotation.*;

/**
 * 需要token 的验证
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@RequestMapping
public @interface AuthTokenRequired {
     String value()default "";
     RequestMethod method()default RequestMethod.GET ;
}
