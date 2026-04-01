package com.QuestionService.config;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetAppProperties {
    private RedisProperties redisProperties;

    public GetAppProperties(RedisProperties redisProperties) {
        this.redisProperties = redisProperties;
    }

    @PostConstruct
    public void init(){
        System.out.println(redisProperties.getHost());
        System.out.println(redisProperties.getPort());

    }
}
