package com.yunlong.frame.security.exception;

import org.springframework.http.HttpStatus;

/**
 * @author TAO
 * @description: 拒绝访问Exception
 * @date 2021/9/29 22:10
 */
public class ForbiddenException extends ExtendOAuth2Exception {

    public ForbiddenException(String msg, Throwable t) {
        super(msg, t);
    }

    @Override
    public String getOAuth2ErrorCode() {
        return "access_denied---拒绝访问";
    }

    @Override
    public int getHttpErrorCode() {
        return HttpStatus.FORBIDDEN.value();
    }

}
