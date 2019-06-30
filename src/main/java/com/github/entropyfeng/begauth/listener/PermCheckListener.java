package com.github.entropyfeng.begauth.listener;

import com.github.entropyfeng.begauth.event.PermCheckEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @author entropyfeng
 * @date 2019/6/12 19:08
 */
@Component
public class PermCheckListener {

    private static final Logger logger =LoggerFactory.getLogger(PermCheckListener.class);

    @EventListener
    public void permCheck(PermCheckEvent permCheckEvent){

        logger.info(permCheckEvent.getPerm());
    }
}
