package com.QuestionService.config;


import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
@NoArgsConstructor
@Component
@ConfigurationProperties(prefix = "spring.data.redis")
public class RedisProperties {
  String host;
  int port;

    public void setHost(String host) {
        this.host = host;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getHost() {
        return host;
    }

    public int getPort() {
        return port;
    }
}
