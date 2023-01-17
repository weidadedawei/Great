package com.yunlong.frame.log.aspect;

import cn.hutool.core.util.StrUtil;
import cn.hutool.extra.servlet.ServletUtil;
import cn.hutool.extra.spring.SpringUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.yunlong.frame.log.annotation.SysLog;
import com.yunlong.frame.log.dto.SysLogDTO;
import com.yunlong.frame.log.event.SaveSysLogEvent;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.time.LocalDateTime;

/**
 * 操作日志切面处理
 *
 * @author david
 * @date 2023-01-02 11:18
 */
@Component
@Aspect
@RequiredArgsConstructor
public class SysLogAspect {

    private final ApplicationEventPublisher publisher;
    String AT = "@";
    String SPRING_APPLICATION_NAME = "spring.application.name";
    /**
     * 处理时间毫秒
     */
    private Long consumingTime = null;

    /**
     * 配置织入点
     */
    @Pointcut("@annotation(com.yunlong.frame.log.annotation.SysLog)")
    public void logPointCut() {
    }

    /**
     * Before 在核心业务执行前执行，不能阻止核心业务的调用。
     *
     * @param joinPoint
     */
    @Before("logPointCut()")
    public void beforeAdvice(JoinPoint joinPoint) throws Exception {
        // 获得注解
        SysLog sysLog = getActionLog(joinPoint);
        if (sysLog == null) {
            return;
        }
    }

    /**
     * 前置通知 用于拦截Controller/service层记录用户的操作 核心业务逻辑调用正常退出后，不管是否有返回值，正常退出后，均执行此Advice
     *
     * @param joinPoint 切点
     */
    @AfterReturning(pointcut = "logPointCut()", returning = "result")
    public void doBefore(JoinPoint joinPoint, Object result) {
        handleLog(joinPoint, result, null);
    }

    /**
     * After 核心业务逻辑退出后（包括正常执行结束和异常退出），执行此Advice
     *
     * @param joinPoint
     */
    @After(value = "logPointCut()")
    public void afterAdvice(JoinPoint joinPoint) throws Exception {
        // 获得注解
        SysLog sysLog = getActionLog(joinPoint);
        if (sysLog == null) {
            return;
        }
    }

    /**
     * Around 手动控制调用核心业务逻辑，以及调用前和调用后的处理,
     * <p/>
     * 注意：当核心业务抛异常后，立即退出，转向AfterAdvice 执行完AfterAdvice，再转到ThrowingAdvice
     *
     * @param pjp
     * @return
     * @throws Throwable
     */
    @Around(value = "logPointCut()")
    public Object aroundAdvice(ProceedingJoinPoint pjp) throws Throwable {
        // 此处可以做类似于Before Advice的事情
        long start = System.currentTimeMillis();
        // 调用核心逻辑
        Object retVal = pjp.proceed();
        consumingTime = System.currentTimeMillis() - start;
        // 此处可以做类似于After Advice的事情
        return retVal;
    }

    /**
     * 后置通知 用于拦截Controller/service层记录用户的操作 核心业务逻辑调用异常退出后，执行此Advice，处理错误信息 注意：执行顺序在Around Advice之后
     *
     * @param joinPoint 切点
     */
    @AfterThrowing(value = "logPointCut()", throwing = "e")
    public void doAfter(JoinPoint joinPoint, Exception e) {
        handleLog(joinPoint, null, e);
    }

    /**
     * 获取注解中对方法的描述信息 用于Controller层注解
     *
     * @return 方法描述
     * @throws Exception
     */
    public void getControllerMethodDescription(JoinPoint joinPoint, SysLog sysLog, SysLogDTO operationLogger,
                                               HttpServletRequest request, HttpServletResponse response, Object result) {
        // 设置action动作
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        operationLogger.setMethodName(method.getName());
        operationLogger.setClassName(signature.getDeclaringType().getName());
        // 设置标题
        operationLogger.setTitle(sysLog.value());
        // 设置应用名
        operationLogger.setAppName(SpringUtil.getProperty(SPRING_APPLICATION_NAME));
        // 设置请求方式
        operationLogger.setRequestMethod(request.getMethod());
        // 是否需要保存request，参数和值
        if (sysLog.isSaveParam()) {
            // 获取参数的信息，传入到数据库中。
            setRequestValue(joinPoint, operationLogger);
//            setRequestValue(joinPoint, operationLogger, request);
        }
        // 是否需要保存response，结果
        if (sysLog.isSaveResult() && response != null) {
            // 获取response
            operationLogger.setResponseStatus(response.getStatus());
            operationLogger.setResponseContent(getResponseContent(result));
        }
    }

    private void handleLog(JoinPoint joinPoint, Object result, Exception e) {
        try {
            // 获得注解
            SysLog sysLog = getActionLog(joinPoint);
            if (sysLog == null) {
                return;
            }
            RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
            HttpServletRequest request = null;
            HttpServletResponse response = null;
            SysLogDTO sysLogDto = new SysLogDTO();
            sysLogDto.setCreateTime(LocalDateTime.now());
//            if (actionLog.isLogSql()) {
//                sysOperLog.setSeries(SqlLogHelper.threadLocalSeries());
//                sysOperLog.setSeriesIndex(SqlLogHelper.threadLocalSeriesIndex());
//            }

            if (requestAttributes != null) {
                request = ((ServletRequestAttributes) requestAttributes).getRequest();
                response = ((ServletRequestAttributes) requestAttributes).getResponse();
                sysLogDto.setIp(ServletUtil.getClientIP(request));
                sysLogDto.setUrl(request.getRequestURI());
                sysLogDto.setUserAgent(request.getHeader("user-agent"));

//                String userStr = ServletUtils.getRequest().getHeader(SecurityConstants.USER_TOKEN_HEADER);
//                if (StringUtils.isNotBlank(userStr)) {
//                    UserDto userDto = JSONUtil.toBean(userStr, UserDto.class);
//                    sysOperLog.setUserId(userDto.getUserId());
//                }
            }

            sysLogDto.setConsumingTime(consumingTime);
            if (e != null) {
//                if (e instanceof BaseAppException) {
//                    sysOperLog.setErrorCode(((BaseAppException) e).getKey());
//                } else {
                sysLogDto.setErrorCode(e.getClass().getName());
//                }
                sysLogDto.setErrorMessage(e.getMessage());
            }

            // 处理设置注解上的参数
            getControllerMethodDescription(joinPoint, sysLog, sysLogDto, request, response, result);

            // 事件驱动保存日志
            publisher.publishEvent(new SaveSysLogEvent(sysLogDto));

        } catch (Exception exp) {
            exp.printStackTrace();
        }
    }

    /**
     * 获取请求的参数，放到log中
     *
     * @param operationLogger 操作日志
     * @throws Exception 异常
     */
    private void setRequestValue(JoinPoint joinPoint, SysLogDTO operationLogger) {
        String requestMethod = operationLogger.getRequestMethod();
        if (HttpMethod.PUT.name().equals(requestMethod) || HttpMethod.POST.name().equals(requestMethod)) {
            String params = argsArrayToString(joinPoint.getArgs());
            operationLogger.setParameter(StrUtil.sub(params, 0, 20000));
        }
    }

    /**
     * 参数拼装
     */
    private String argsArrayToString(Object[] paramsArray) {
        String params = "";
        if (paramsArray != null && paramsArray.length > 0) {
            for (int i = 0; i < paramsArray.length; i++) {
                if (!isFilterObject(paramsArray[i])) {
                    try {
                        JSONObject jsonObj = JSONUtil.parseObj(paramsArray[i]);
                        params += jsonObj + " ";
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return params.trim();
    }

    /**
     * 判断是否需要过滤的对象。
     *
     * @param o 对象信息。
     * @return 如果是需要过滤的对象，则返回true；否则返回false。
     */
    public boolean isFilterObject(final Object o) {
        return o instanceof MultipartFile || o instanceof HttpServletRequest || o instanceof HttpServletResponse;
    }

    /**
     * 是否存在注解，如果存在就记录日志
     *
     * @param joinPoint
     * @return
     * @throws Exception
     */
    private SysLog getActionLog(JoinPoint joinPoint) throws Exception {
        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();

        if (method != null) {
            return method.getAnnotation(SysLog.class);
        }
        return null;
    }

    /**
     * 结果转为字符串
     *
     * @param result
     * @return
     */
    private String getResponseContent(Object result) {
        String returnValue = null;
        if (null != result) {
            returnValue = JSONUtil.parse(result).toString();
//            if (result.toString().endsWith(AT + Integer.toHexString(result.hashCode()))) {
//                returnValue = ReflectionToStringBuilder.toString(result);
//            } else {
//                returnValue = result.toString();
//            }
        }
        return returnValue;
    }
}