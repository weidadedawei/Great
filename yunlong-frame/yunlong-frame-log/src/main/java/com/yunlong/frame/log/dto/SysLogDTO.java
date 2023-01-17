package com.yunlong.frame.log.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 系统日志
 *
 * @author david liu
 * @since 2020-02-07
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(value = "SysLogDto", description = "系统日志")
public class SysLogDTO {

    private static final long serialVersionUID = 1L;

    private Long logId;

    @ApiModelProperty(value = "应用名")
    private String appName;

    @ApiModelProperty(value = "IP")
    private String ip;

    @ApiModelProperty(value = "请求链接")
    private String url;

    @ApiModelProperty(value = "错误编码")
    private String errorCode;

    @ApiModelProperty(value = "错误信息")
    private String errorMessage;

    @ApiModelProperty(value = "请求方法")
    private String requestMethod;

    @ApiModelProperty(value = "标题")
    private String title;

    @ApiModelProperty(value = "类方法名")
    private String methodName;

    @ApiModelProperty(value = "类名")
    private String className;

    @ApiModelProperty(value = "用户代理")
    private String userAgent;

    @ApiModelProperty(value = "请求参数")
    private String parameter;

    @ApiModelProperty(value = "执行时间毫秒")
    private Long consumingTime;

    @ApiModelProperty(value = "响应码")
    private Integer responseStatus;

    @ApiModelProperty(value = "响应内容")
    private String responseContent;

    /**
     * 创建人
     */
    @ApiModelProperty(value = "创建人")
    private String createBy;

    /**
     * 修改人
     */
    @ApiModelProperty(value = "修改人")
    private String updateBy;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    @ApiModelProperty(value = "修改时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime updateTime;

    /**
     * 是否删除0：否1：是
     */
    @ApiModelProperty(value = "是否删除0：否1：是")
    private Integer delFlag;

    /**
     * 所属租户
     */
    @ApiModelProperty(value = "所属租户")
    private Long tenantId;
}
