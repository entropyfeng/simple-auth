package com.github.entropyfeng.simpleauth.service.impl;

import com.github.entropyfeng.simpleauth.config.AuthProperties;
import com.github.entropyfeng.simpleauth.service.IDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.support.atomic.RedisAtomicInteger;
import org.springframework.stereotype.Service;

/**
 * @author entropyfeng
 * @date 2020/1/5 17:04
 */
@Service
public class IDServiceImpl implements IDService {



    private final RedisAtomicInteger redisUserIdAtomicInteger;

    private final RedisAtomicInteger redisRoleIdAtomicInteger;

    private final RedisAtomicInteger redisResourceIdAtomicInteger;

    @Autowired
    public IDServiceImpl(RedisTemplate redisTemplate) {

        redisUserIdAtomicInteger=new RedisAtomicInteger(AuthProperties.GLOBAL_USER_ID_NAME,redisTemplate.getConnectionFactory());

        redisRoleIdAtomicInteger=new RedisAtomicInteger(AuthProperties.GLOBAL_ROLE_ID_NAME,redisTemplate.getConnectionFactory());

        redisResourceIdAtomicInteger=new RedisAtomicInteger(AuthProperties.GLOBAL_RESOURCE_ID_NAME,redisTemplate.getConnectionFactory());


    }

    @Override
    public int getGlobalUniqueId() {
        return redisUserIdAtomicInteger.getAndIncrement();
    }


    @Override
    public int getGlobalRoleId() {
        return redisRoleIdAtomicInteger.getAndIncrement();
    }

    @Override
    public int getGlobalResourceId() {
        return redisResourceIdAtomicInteger.getAndIncrement();
    }
}
