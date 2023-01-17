package com.yunlong.frame.security.exception;

import org.springframework.http.HttpStatus;

/**
 * @author TAO
 * @description: 服务器内部Exception
 * @date 2021/9/29 22:20
 */
public class ServerErrorException extends ExtendOAuth2Exception {

    public ServerErrorException(String msg, Throwable t) {
        super(msg, t);
    }

    @Override
    public String getOAuth2ErrorCode() {
        return "server_error---服务器内部异常";
    }

    @Override
    public int getHttpErrorCode() {
        return HttpStatus.INTERNAL_SERVER_ERROR.value();
    }

}
