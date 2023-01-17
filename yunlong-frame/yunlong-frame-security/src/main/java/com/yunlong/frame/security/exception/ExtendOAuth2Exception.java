package com.yunlong.frame.security.exception;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.yunlong.frame.security.exception.serializer.ExtendOAuth2ExceptionSerializer;
import lombok.Getter;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;

/**
 * @author TAO
 * @description: 扩展OAuth2Exception
 * @date 2021/9/29 22:14
 */
@JsonSerialize(using = ExtendOAuth2ExceptionSerializer.class)
public class ExtendOAuth2Exception extends OAuth2Exception {

    @Getter
    private String dataMsg;

    public ExtendOAuth2Exception(String msg) {
        super(msg);
    }

    public ExtendOAuth2Exception(String msg, Throwable t) {
        super(msg, t);
    }

    public ExtendOAuth2Exception(String msg, String dataMsg) {
        super(msg);
        this.dataMsg = dataMsg;

    }

}
