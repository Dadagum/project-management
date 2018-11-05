package com.dadagum.team.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {

    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory){
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(factory);

        StringRedisSerializer stringSerializer = new StringRedisSerializer();
        JdkSerializationRedisSerializer jdkSerializer = new JdkSerializationRedisSerializer();
        redisTemplate.setHashValueSerializer(jdkSerializer);
        redisTemplate.setValueSerializer(jdkSerializer);
        redisTemplate.setHashKeySerializer(stringSerializer);
        redisTemplate.setKeySerializer(stringSerializer);

        return redisTemplate;
    }
}
