package com.yunlong.frame.core.util;

import com.yunlong.frame.core.constant.WebConstants;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 响应信息主体
 *
 * @param <T>
 * @author david
 */
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@ApiModel(value = "响应信息主体")
public class R<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter
    @Setter
    @ApiModelProperty(value = "返回标记：成功标记=0，失败标记=1")
    private int code;

    @Getter
    @Setter
    @ApiModelProperty(value = "返回信息")
    private String msg;

    @Getter
    @Setter
    @ApiModelProperty(value = "数据")
    private T data;

    public static <T> R<T> success() {
        return restResult(null, WebConstants.SUCCESS, null);
    }

    public static <T> R<T> success(T data) {
        return restResult(data, WebConstants.SUCCESS, null);
    }

    public static <T> R<T> success(T data, String msg) {
        return restResult(data, WebConstants.SUCCESS, msg);
    }

    public static <T> R<T> failed() {
        return restResult(null, WebConstants.FAIL, null);
    }

    public static <T> R<T> failed(String msg) {
        return restResult(null, WebConstants.FAIL, msg);
    }

    public static <T> R<T> failed(T data) {
        return restResult(data, WebConstants.FAIL, null);
    }

    public static <T> R<T> failed(T data, String msg) {
        return restResult(data, WebConstants.FAIL, msg);
    }

    static <T> R<T> restResult(T data, int code, String msg) {
        R<T> apiResult = new R<>();
        apiResult.setCode(code);
        apiResult.setData(data);
        apiResult.setMsg(msg);
        return apiResult;
    }

}
