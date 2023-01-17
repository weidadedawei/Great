package com.yunlong.frame.security.handler;

import cn.hutool.http.HttpStatus;
import com.yunlong.frame.core.util.R;
import com.yunlong.frame.core.util.ServletUtils;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.client.resource.OAuth2AccessDeniedException;
import org.springframework.security.oauth2.common.exceptions.InvalidTokenException;
import org.springframework.security.oauth2.provider.error.OAuth2AuthenticationEntryPoint;
import org.springframework.security.web.access.ExceptionTranslationFilter;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 资源服异常： 解决访问一个需要认证的 URL 资源，但是此时自己尚未认证（登录）的异常处理器
 * 实际上也就是用户没有认证过,请求头中没有携带了Token，或者是resource_ids范围不够
 * 补充：Spring Security 通过 {@link ExceptionTranslationFilter#sendStartAuthentication(HttpServletRequest, HttpServletResponse, FilterChain, AuthenticationException)} 方法，调用当前类
 *
 * @author david
 * @date 2023/1/16 22:43
 */
@Slf4j
public class YunLongAuthenticationEntryPointHandlerImpl extends OAuth2AuthenticationEntryPoint {

    @Override
    @SneakyThrows
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) {
        log.error("[commence][访问 URL({}) 时，没有登录]", request.getRequestURI(), authException);

        R<String> result = new R<>();
        result.setCode(HttpStatus.HTTP_UNAUTHORIZED);
        String msg = "";
        log.error("匿名用户访问无权限资源时的异常");
        if (authException != null) {
            log.error("errorMsg===>" + authException.getMessage());
            msg = "访问此资源需要完全身份验证";
        }
        Throwable cause = authException.getCause();
        if (cause instanceof OAuth2AccessDeniedException) {
            msg += " resource_ids范围不够";
            log.error("resource_ids范围不够");
        } else if (cause instanceof InvalidTokenException) {
            msg += " Token解析失败";
            log.error("Token解析失败");
        } else if (authException instanceof InsufficientAuthenticationException) {
            msg += " 未携带token";
            log.error("未携带token");
        }
        result.setMsg(msg);
        // TODO: 响应码考虑一下，是否返回 401还是 200
        //  response.setStatus(HttpStatus.HTTP_UNAUTHORIZED);
        ServletUtils.writeJSON(response, result);
    }

}
