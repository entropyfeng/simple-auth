package com.github.entropyfeng.begauth.config.init;

import com.github.entropyfeng.begauth.event.LoadAuthDomainEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

/**
 * 应用启动时发布一个加载 所有角色及所属权限到 redis 的事件
 * @author entropyfeng
 */
@Component
public class AuthApplicationRunner implements ApplicationRunner {


    private Logger logger =LoggerFactory.getLogger(AuthApplicationRunner.class);

    @Autowired
    ApplicationEventPublisher eventPublisher;


    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
        logger.info("publish loadAuthDomain Event");
        eventPublisher.publishEvent(new LoadAuthDomainEvent(this));
    }


}
