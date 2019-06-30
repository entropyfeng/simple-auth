package com.github.entropyfeng.begauth.config.anno;

import java.lang.annotation.*;

/**
 * @author entropyfeng
 * @date 2019/6/18 17:12
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface EncryptRequired {
}
