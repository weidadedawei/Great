package com.yunlong.frame.security.config;

import com.yunlong.frame.security.compontent.PermitAllUrlResolver;
import com.yunlong.frame.security.handler.YunLongAccessDeniedHandlerImpl;
import com.yunlong.frame.security.handler.YunLongAuthenticationEntryPointHandlerImpl;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.web.context.WebApplicationContext;

/**
 * 资源服务器配置
 */
@Configuration
@AllArgsConstructor
public class ResourceServiceConfig extends ResourceServerConfigurerAdapter {

    private final TokenStore redisTokenStore;

    private final WebApplicationContext applicationContext;

    @Bean
    public PermitAllUrlResolver permitAllUrlResolver() {
        return new PermitAllUrlResolver(applicationContext);
    }

    /**
     * 权限不够处理器 Bean
     */
    @Bean
    public AccessDeniedHandler yunLongAccessDeniedHandler() {
        return new YunLongAccessDeniedHandlerImpl();
    }

    /**
     * 认证失败处理类 Bean
     */
    @Bean
    public AuthenticationEntryPoint yunLongAuthenticationEntryPointHandler() {
        return new YunLongAuthenticationEntryPointHandlerImpl();
    }

    @Override
    public void configure(HttpSecurity httpSecurity) throws Exception {
        // 允许使用iframe 嵌套，避免swagger-ui 不被加载的问题
        httpSecurity.headers().frameOptions().disable();
        //授权的请求
        ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry registry = httpSecurity
                .authorizeRequests();
        // 配置对外暴露接口
        permitAllUrlResolver().registry(registry);
        registry
                .anyRequest()// 其他请求
                .authenticated()// 都需要认证
                .and().csrf().disable();//关闭csrf
    }

    /**
     * 资源服配置Token存储策略
     *
     * @param resources configurer for the resource server
     */
    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources
                .tokenStore(redisTokenStore)
                .authenticationEntryPoint(yunLongAuthenticationEntryPointHandler())//匿名用户访问无权限资源时的异常处理器
                .accessDeniedHandler(yunLongAccessDeniedHandler())//认证过的用户访问无权限资源时的异常处理器
                .stateless(true);
    }

}