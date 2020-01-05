package com.github.entropyfeng.simpleauth.config.anno;

import java.lang.annotation.*;

/**
 * @author entropyfeng
 * @date 2019/6/12 15:40
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface PutAuth {

    String value()default "";

}
