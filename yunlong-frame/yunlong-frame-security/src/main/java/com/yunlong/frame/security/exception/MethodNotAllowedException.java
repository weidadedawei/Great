package com.yunlong.frame.security.exception;

import org.springframework.http.HttpStatus;

/**
 * @author TAO
 * @description: 方法不允许访问Exception
 * @date 2021/9/29 22:18
 */
public class MethodNotAllowedException extends ExtendOAuth2Exception {

    public MethodNotAllowedException(String msg, Throwable t) {
        super(msg, t);
    }

    @Override
    public String getOAuth2ErrorCode() {
        return "method_not_allowed---方法不允许访问";
    }

    @Override
    public int getHttpErrorCode() {
        return HttpStatus.METHOD_NOT_ALLOWED.value();
    }

}
