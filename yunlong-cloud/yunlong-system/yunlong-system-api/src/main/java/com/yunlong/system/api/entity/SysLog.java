package com.yunlong.system.api.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * 日志表(SysLog)表实体类
 *
 * @author david
 * @date 2023-01-04 17:31:06
 */
@Data
@TableName("sys_log")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "审核日志表")
public class SysLog extends Model<SysLog> {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    @TableId
    @ApiModelProperty(value = "编号")
    private Long logId;

    /**
     * 标题
     */
    @ApiModelProperty(value = "标题")
    private String title;

    /**
     * 应用名
     */
    @ApiModelProperty(value = "应用名")
    private String appName;

    /**
     * ip地址
     */
    @ApiModelProperty(value = "ip地址")
    private String ip;

    /**
     * 请求链接
     */
    @ApiModelProperty(value = "请求链接")
    private String url;

    /**
     * 类方法名
     */
    @ApiModelProperty(value = "类方法名")
    private String methodName;

    /**
     * 类名
     */
    @ApiModelProperty(value = "类名")
    private String className;

    /**
     * 请求方法
     */
    @ApiModelProperty(value = "请求方法")
    private String requestMethod;

    /**
     * 响应码
     */
    @ApiModelProperty(value = "响应码")
    private Integer responseStatus;

    /**
     * 响应内容
     */
    @ApiModelProperty(value = "响应内容")
    private String responseContent;

    /**
     * 浏览器信息
     */
    @ApiModelProperty(value = "浏览器信息")
    private String userAgent;

    /**
     * 请求参数
     */
    @ApiModelProperty(value = "请求参数")
    private String parameter;

    /**
     * 执行时间毫秒
     */
    @ApiModelProperty(value = "执行时间毫秒")
    private Long consumingTime;

    /**
     * 错误编码
     */
    @ApiModelProperty(value = "错误编码")
    private String errorCode;

    /**
     * 错误信息
     */
    @ApiModelProperty(value = "错误信息")
    private String errorMessage;

    /**
     * 创建人
     */
    @TableField(fill = FieldFill.INSERT)
    @ApiModelProperty(value = "创建人")
    private String creator;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    /**
     * 修改人
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    @ApiModelProperty(value = "修改人")
    private String updater;

    /**
     * 更新时间
     */
    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updateTime;

    /**
     * 删除标识
     */
    @TableLogic
    @ApiModelProperty(value = "删除标识")
    private Boolean delFlag;

    /**
     * 所属租户
     */
    @ApiModelProperty(value = "所属租户")
    private Long tenantId;

}
