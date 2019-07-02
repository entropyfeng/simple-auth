package com.github.entropyfeng.simpleauth.config.anno;

import java.lang.annotation.*;

/**
 * @author entropyfeng
 * 要求kaptcha验证
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface KaptchaRequired {
}
