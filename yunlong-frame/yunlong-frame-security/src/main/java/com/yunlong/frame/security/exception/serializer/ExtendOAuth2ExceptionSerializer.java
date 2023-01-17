package com.yunlong.frame.security.exception.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.yunlong.frame.security.exception.ExtendOAuth2Exception;

import java.io.IOException;

/**
 * @author TAO
 * @description: ExtendOAuth2Exception返回格式序列化
 * @date 2021/9/29 22:42
 */
public class ExtendOAuth2ExceptionSerializer extends StdSerializer<ExtendOAuth2Exception> {

    public ExtendOAuth2ExceptionSerializer() {
        super(ExtendOAuth2Exception.class);
    }

    @Override
    public void serialize(ExtendOAuth2Exception e, JsonGenerator gen, SerializerProvider serializerProvider) throws IOException {
        gen.writeStartObject();
        gen.writeObjectField("code", String.valueOf(e.getHttpErrorCode()));
        gen.writeStringField("msg", e.getMessage());
        gen.writeStringField("data", e.getDataMsg());
        gen.writeEndObject();

    }
}
