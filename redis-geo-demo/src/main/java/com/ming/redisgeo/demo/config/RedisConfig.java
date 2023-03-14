package com.ming.redisgeo.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;

/**
 * @author 贺春明
 * @date 2023/3/14
 */

@Configuration
public class RedisConfig {

//    @Bean
//    public RedisTemplate<String,String> stringRedisTemplate(RedisConnectionFactory connectionFactory){
//        RedisTemplate redisTemplate = new RedisTemplate();
//        redisTemplate.setConnectionFactory(connectionFactory);
//        redisTemplate.setKeySerializer(RedisSerializer.string());
//        redisTemplate.setHashKeySerializer(RedisSerializer.string());
//        redisTemplate.setKeySerializer(RedisSerializer.string());
//        redisTemplate.setHashKeySerializer(RedisSerializer.string());
//        return redisTemplate;
//    }

    @Bean
    public RedisTemplate<String,Object> jsonRedisTemplate(RedisConnectionFactory connectionFactory){
        RedisTemplate redisTemplate = new RedisTemplate();
        redisTemplate.setConnectionFactory(connectionFactory);
        redisTemplate.setKeySerializer(RedisSerializer.string());
        redisTemplate.setHashKeySerializer(RedisSerializer.string());
        redisTemplate.setKeySerializer(RedisSerializer.json());
        redisTemplate.setHashKeySerializer(RedisSerializer.json());
        return redisTemplate;
    }
}
