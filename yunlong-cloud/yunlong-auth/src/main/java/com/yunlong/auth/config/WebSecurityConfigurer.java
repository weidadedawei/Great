package com.yunlong.auth.config;

import com.yunlong.frame.security.service.YunLongUserDetailsServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * SpringSecurity核心配置
 *
 * @author david
 * @date 2023/1/15
 */
@Primary
@Order(90)
@Configuration
@RequiredArgsConstructor
public class WebSecurityConfigurer extends WebSecurityConfigurerAdapter {

    @Autowired
    private YunLongUserDetailsServiceImpl yunLongUserDetailsServiceImpl;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 获取用户信息
        auth.userDetailsService(yunLongUserDetailsServiceImpl).passwordEncoder(passwordEncoder());
    }

    /**
     * 密码处理器
     * @return 动态密码处理器 {类型}密文
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }


    @Override
    @SneakyThrows
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin().permitAll()
                .and().authorizeRequests()
                .antMatchers("/oauth/**","/token/**", "/actuator/**").permitAll()
                .anyRequest().authenticated()
                .and().logout().permitAll()
                .and().cors().disable();

//        http
////                .exceptionHandling()
////                .authenticationEntryPoint(authenticationEntryPoint())
////				.accessDeniedHandler(accessDeniedHandler())
//                .formLogin().permitAll()  // 配置登录页
////                .and().requestMatchers()//系统中所有请求
////                .antMatchers("/**")//SpringSecurity接管的请求/**系统所有请求
//                .and().authorizeRequests() //得到SpringSecurity接管的请求
//                .antMatchers("/oauth/**")
//                .permitAll()//放行，无需权限
//                .anyRequest()//其他请求
//                .authenticated()//都需要认证
//                .and().logout().permitAll()
//                .and().cors().disable(); //关闭csrf
    }

//	/**
//	 * 自定义 provider 列表注入
//	 * @param auth AuthenticationManagerBuilder
//	 */
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) {
//		PigxDaoAuthenticationProvider daoAuthenticationProvider = new PigxDaoAuthenticationProvider();
//		daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
//
//		// 处理默认的密码模式认证
//		auth.authenticationProvider(daoAuthenticationProvider);
//		// 自定义的认证模式
//		auth.authenticationProvider(new CustomAppAuthenticationProvider());
//	}

    /**
     * 配置认证管理器-支持密码模式
     *
     * @return
     */
    @Bean
    @Override
    @SneakyThrows
    public AuthenticationManager authenticationManagerBean() {
        return super.authenticationManagerBean();
    }

}
