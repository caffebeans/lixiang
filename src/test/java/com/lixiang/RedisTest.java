package com.lixiang;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

/**
 * @description:
 * @author: 张亮
 * @date: 2021/11/23
 **/
public class RedisTest extends LixiangApplicationTests{

    @Autowired
    RedisTemplate<String,String> redisTemplate;

    @Test
    void connection() {


    }
}
