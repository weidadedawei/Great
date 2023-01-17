package com.yunlong.frame.security.handler;

import cn.hutool.http.HttpStatus;
import com.yunlong.frame.core.constant.GlobalErrorCodeConstants;
import com.yunlong.frame.core.util.R;
import com.yunlong.frame.core.util.ServletUtils;
import com.yunlong.frame.security.util.SecurityFrameworkUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.access.ExceptionTranslationFilter;
import org.springframework.stereotype.Component;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * 资源服异常：用户访问无权限资源时的异常处理器
 * <p>
 * 访问一个需要认证的 URL 资源，已经认证（登录）但是没有权限的情况下，返回 {@link GlobalErrorCodeConstants#FORBIDDEN} 错误码。
 * <p>
 * 补充：Spring Security 通过 {@link ExceptionTranslationFilter#handleAccessDeniedException(HttpServletRequest, HttpServletResponse, FilterChain, AccessDeniedException)} 方法，调用当前类
 *
 * @author david
 */
@Slf4j
@Component("yunLongAccessDeniedHandlerImpl")
public class YunLongAccessDeniedHandlerImpl implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException e)
            throws IOException, ServletException {
        log.error("[commence][访问 URL({}) 时，用户({}) 权限不够]", request.getRequestURI(),
                SecurityFrameworkUtils.getLoginUserId(), e);
        // 返回 权限不足403 ，认证过的用户访问无权限资源时的异常
        R<String> result = new R<>();
        result.setCode(HttpStatus.HTTP_FORBIDDEN);
        result.setMsg("认证过的用户访问无权限资源时的异常");
//        ServletUtils.writeJSON(response, R.failed(GlobalErrorCodeConstants.FORBIDDEN));
        ServletUtils.writeJSON(response, result);
    }

}
