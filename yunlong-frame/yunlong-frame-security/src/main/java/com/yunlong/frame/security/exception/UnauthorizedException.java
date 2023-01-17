package com.yunlong.frame.security.exception;

import org.springframework.http.HttpStatus;

/**
 * @author TAO
 * @description: 未授权Exception
 * @date 2021/9/29 22:21
 */
public class UnauthorizedException extends ExtendOAuth2Exception {

    public UnauthorizedException(String msg, Throwable t) {
        super(msg, t);
    }

    @Override
    public String getOAuth2ErrorCode() {
        return "unauthorized---未授权";
    }

    @Override
    public int getHttpErrorCode() {
        return HttpStatus.UNAUTHORIZED.value();
    }

}
