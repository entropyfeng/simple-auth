package com.github.entropyfeng.simpleauth.config.anno;

import org.springframework.stereotype.Component;

import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author entropyfeng
 * @date 2019/7/15 23:07
 */

@Component
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Realm {
}
