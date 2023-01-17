package com.yunlong.frame.log.annotation;

import java.lang.annotation.*;

/**
 * @author david
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SysLog {

    /**
     * 操作的名称
     */
    String value() default "";

    /**
     * 是否保存请求的参数
     */
    boolean isSaveParam() default true;

    /**
     * 渠道
     */
    String channel() default "";

    /**
     * 是否记录sql日志到mongodb
     **/
    boolean isLogSql() default true;

    /**
     * 是否保存请求响应结果
     **/
    boolean isSaveResult() default true;

}