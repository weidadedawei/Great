package com.yunlong.frame.security.aspect;

import cn.hutool.core.util.StrUtil;
import com.yunlong.frame.core.constant.SecurityConstants;
import com.yunlong.frame.security.annotation.Inner;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.security.access.AccessDeniedException;

import javax.servlet.http.HttpServletRequest;

/**
 * 服务间接口不鉴权处理逻辑
 * @author david
 * @date 2023-1-17
 */
@Slf4j
@Aspect
@AllArgsConstructor
public class YunLongSecurityInnerAspect {

	private final HttpServletRequest request;

	@SneakyThrows
	@Around("@within(inner) || @annotation(inner)")
	public Object around(ProceedingJoinPoint point, Inner inner) {
		// 先判断 inner 是否为空, 为空则获取类上注解
		if (inner == null) {
			Class<?> aClass = point.getTarget().getClass();
			inner = AnnotationUtils.findAnnotation(aClass, Inner.class);
		}

		String header = request.getHeader(SecurityConstants.FROM);
		if (inner.value() && !StrUtil.equals(SecurityConstants.FROM_IN, header)) {
			log.warn("访问接口 {} 没有权限", inner.value());
			throw new AccessDeniedException("权限不足,不允许访问"+inner.value());
		}
		return point.proceed();
	}

}
