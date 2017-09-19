package com.wangcg.util;


import org.springframework.data.redis.core.StringRedisTemplate;

import javax.annotation.Resource;


public class SpringRedis {

    @Resource(name="redisTemplate")
    private StringRedisTemplate redisTemplate;


}
