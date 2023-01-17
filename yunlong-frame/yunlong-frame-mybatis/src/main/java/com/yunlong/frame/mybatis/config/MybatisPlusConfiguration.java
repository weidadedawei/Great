package com.yunlong.frame.mybatis.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import com.yunlong.frame.mybatis.handler.YunLongDBFieldHandler;
import com.yunlong.frame.mybatis.resolver.SqlFilterArgumentResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * @author sc
 * @date 2022/11/10 6:51 PM
 */
@Configuration
@EnableTransactionManagement
public class MybatisPlusConfiguration implements WebMvcConfigurer {

    /**
     * SQL 过滤器避免SQL 注入
     *
     * @param argumentResolvers
     */
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(new SqlFilterArgumentResolver());
    }

    /**
     * mybatis plus 拦截器配置
     *
     * @return PigxDefaultDatascopeHandle
     */
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        // 分页插件
        PaginationInnerInterceptor paginationInnerInterceptor = new PaginationInnerInterceptor();
        paginationInnerInterceptor.setMaxLimit(1000L);
        interceptor.addInnerInterceptor(paginationInnerInterceptor);
        return interceptor;
    }

    /**
     * SQL 日志格式化
     * @return DruidSqlLogFilter
     */
    @Bean
    public DruidSqlLogFilter sqlLogFilter() {
        return new DruidSqlLogFilter();
    }

    /**
     * 自动填充参数类
     *
     * @return
     */
    @Bean
    public MetaObjectHandler defaultMetaObjectHandler() {
        return new YunLongDBFieldHandler();
    }
}
