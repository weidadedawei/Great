package com.yunlong.frame.security.exception;

/**
 * @author TAO
 * @description: 授权模式Exception
 * @date 2021/10/1 16:21
 */
public class GrantTypeException extends ExtendOAuth2Exception {

    public GrantTypeException(String msg, Throwable t) {
        super(msg, t);
    }

    @Override
    public String getOAuth2ErrorCode() {
        return "不支持当前授权类型！！！";
    }

    @Override
    public int getHttpErrorCode() {
        return 400;
    }

}