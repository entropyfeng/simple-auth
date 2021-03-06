package com.github.entropyfeng.simpleauth.config.anno;

import org.springframework.core.annotation.AliasFor;
import org.springframework.web.bind.annotation.RequestMethod;

import java.lang.annotation.*;

/**
 * @author entropyfeng
 * @date 2019/6/12 15:40
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@AuthTokenRequired(method = RequestMethod.PATCH)
public @interface PatchAuth {
    @AliasFor(
            annotation = AuthTokenRequired.class
    )
    String value()default "";
}
