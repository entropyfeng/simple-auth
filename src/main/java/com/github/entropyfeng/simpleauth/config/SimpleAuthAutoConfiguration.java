package com.github.entropyfeng.simpleauth.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author entropyfeng
 * @date 2019/6/11 15:41
 */
@Configuration
@ComponentScan("com.github.entropyfeng.simpleauth")
public class SimpleAuthAutoConfiguration {

    private final static Logger logger = LoggerFactory.getLogger(SimpleAuthAutoConfiguration.class);

    static {
        logger.info("add auth module into application");
    }
}
