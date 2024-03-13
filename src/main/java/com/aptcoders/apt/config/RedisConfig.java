package com.aptcoders.apt.config;
import com.aptcoders.apt.entity.Cource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
public class RedisConfig {

    @Bean
    public RedisTemplate<String, Cource> redisTemplate() {
        RedisTemplate<String, Cource> template = new RedisTemplate<>();
        template.setConnectionFactory(jedisConnectionFactory());
        return template;
    }

    @Bean
    public JedisConnectionFactory jedisConnectionFactory() {
        JedisConnectionFactory jedisConFactory = new JedisConnectionFactory();
        jedisConFactory.setHostName("localhost"); // Set Redis host
        jedisConFactory.setPort(6379); // Set Redis port
        System.out.println("jedish");
        return jedisConFactory;
    }
}
