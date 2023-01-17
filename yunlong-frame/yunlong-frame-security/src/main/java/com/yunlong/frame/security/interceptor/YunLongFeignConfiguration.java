package com.yunlong.frame.security.interceptor;

import feign.Feign;
import feign.RequestInterceptor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.commons.security.AccessTokenContextRelay;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;

/**
 * fegin 配置增强
 *
 * @author david
 */
@Configuration
@ConditionalOnClass(Feign.class)
public class YunLongFeignConfiguration {

	@Bean
	@ConditionalOnProperty("security.oauth2.client.client-id")
	public RequestInterceptor oauth2FeignRequestInterceptor(OAuth2ClientContext oAuth2ClientContext,
			OAuth2ProtectedResourceDetails resource, AccessTokenContextRelay accessTokenContextRelay) {
		return new YunLongFeignClientInterceptor(oAuth2ClientContext, resource, accessTokenContextRelay);
	}

}
