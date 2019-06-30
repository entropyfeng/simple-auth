package com.github.entropyfeng.begauth.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author entropyfeng
 * @date 2019/6/11 15:41
 */
@Configuration
@ComponentScan("com.github.entropyfeng.begauth")
public class BegAuthAutoConfiguration {

    private final static Logger logger = LoggerFactory.getLogger(BegAuthAutoConfiguration.class);

    static {
        logger.info("add auth module into application");
    }
}
