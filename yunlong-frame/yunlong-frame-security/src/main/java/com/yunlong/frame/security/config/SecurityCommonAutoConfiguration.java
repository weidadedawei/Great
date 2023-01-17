package com.yunlong.frame.security.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

@RequiredArgsConstructor
@Configuration(proxyBeanMethods = false)
public class SecurityCommonAutoConfiguration {

    private final RedisConnectionFactory redisConnectionFactory;
    // Redis中OAuth相关前缀
    String PROJECT_OAUTH_ACCESS = "yunlong:access:";

    /**
     * 授权服务器，资源服务器共用同一个tokenStore，保证tokenStore的存取方式是一致的
     *
     * @return
     */
    @Bean
    public TokenStore redisTokenStore() {
        RedisTokenStore tokenStore = new RedisTokenStore(redisConnectionFactory);
        tokenStore.setPrefix(PROJECT_OAUTH_ACCESS); //设置Redis中OAuth相关前缀
        return tokenStore;
    }
}
