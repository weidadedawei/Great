package com.yunlong.auth.config;

import com.yunlong.frame.security.exception.translator.Auth2ResponseExceptionTranslator;
import com.yunlong.frame.security.service.YunLongUserDetailsServiceImpl;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;

/**
 * OAuth2 授权服务核心配置
 *
 * @author david
 * @date 2023/1/15
 */
@Configuration
// 这个注解必须加上,否则访问测试地址404
@EnableAuthorizationServer
@AllArgsConstructor
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    private final ClientDetailsService yunLongClientDetailsServiceImpl;

    private final TokenStore redisTokenStore;

    private final YunLongUserDetailsServiceImpl yunLongUserDetailsServiceImpl;

    private final AuthenticationManager authenticationManagerBean;


    /**
     * 令牌管理服务
     */
    @Bean
    public AuthorizationServerTokenServices tokenService() {
        DefaultTokenServices service = new DefaultTokenServices();
        service.setClientDetailsService(yunLongClientDetailsServiceImpl);//客户端详情服务
        service.setSupportRefreshToken(true);//支持刷新令牌
        service.setTokenStore(redisTokenStore);//令牌存储策略
        return service;
    }

    /**
     * 配置令牌的访问端点和令牌服务
     *
     * @param endpoints the endpoints configurer
     * @throws Exception
     */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.authenticationManager(authenticationManagerBean) // 认证管理器-授权服配置密码模式
                .allowedTokenEndpointRequestMethods(HttpMethod.GET, HttpMethod.POST)  // 支持GET,POST请求
                .reuseRefreshTokens(false)  // refresh_token是否重复使用
                .userDetailsService(yunLongUserDetailsServiceImpl)
                .exceptionTranslator(new Auth2ResponseExceptionTranslator()) // 设置自定义的异常解析器
                .tokenServices(tokenService()); // 令牌管理服务
    }

    /**
     * 配置允许表单认证
     */
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security.allowFormAuthenticationForClients();
    }

    /**
     * 端点数据配置读取数据库
     * @param clients the client details configurer
     * @throws Exception
     */
    @Override
    @SneakyThrows
    public void configure(ClientDetailsServiceConfigurer clients) {
        clients.withClientDetails(yunLongClientDetailsServiceImpl);
    }


//    @Override
//    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
//        //授权码模式
////        //http://localhost:8080/oauth/authorize?response_type=code&client_id=client&redirect_uri=http://www.baidu.com&scope=all
////        // 简化模式
//        http:
////localhost:8080/oauth/authorize?response_type=token&client_id=client&redirect_uri=http://www.baidu.com&scope=all
//
//        clients.inMemory()
//                // 配置client_id
//                .withClient("client")
//                // 配置client_secret
//                .secret(passwordEncoder.encode("123123"))
//                //配置访问token的有效期
//                .accessTokenValiditySeconds(3600)
//                //配置刷新token的有效期
//                .refreshTokenValiditySeconds(864000)
//                //配置redirect_uri，用于授权成功后跳转
//                .redirectUris("http://www.baidu.com")
//                //配置申请的权限范围
//                .scopes("all")
//                /**
//                 * 配置grant_type，表示授权类型
//                 *
//                 *  authorization_code：授权码模式
//                 *  implicit：简化模式
//                 *  password：密码模式
//                 *  client_credentials: 客户端模式
//                 *  refresh_token: 更新令牌
//                 */
//                .authorizedGrantTypes("authorization_code", "password", "client_credentials", "implicit", "refresh_token");
//
//    }
}
