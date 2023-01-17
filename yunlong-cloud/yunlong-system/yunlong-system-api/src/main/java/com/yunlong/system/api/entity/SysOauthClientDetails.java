package com.yunlong.system.api.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * 终端信息表(SysOauthClientDetails)表实体类
 *
 * @author david
 * @date 2023-01-16 18:23:52
 */
@Data
@TableName("sys_oauth_client_details")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "审核日志表")
public class SysOauthClientDetails extends Model<SysOauthClientDetails> {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId
    @ApiModelProperty(value = "ID")
    private Long id;

    /**
     * 客户端id
     */
    @ApiModelProperty(value = "客户端id")
    private String clientId;

    /**
     * 资源id列表
     */
    @ApiModelProperty(value = "资源id列表")
    private String resourceIds;

    /**
     * 客户端密钥
     */
    @ApiModelProperty(value = "客户端密钥")
    private String clientSecret;

    /**
     * 作用域
     */
    @ApiModelProperty(value = "作用域")
    private String scope;

    /**
     * 授权方式[A,B,C]
     */
    @ApiModelProperty(value = "授权方式[A,B,C]")
    private String[] authorizedGrantTypes;

    /**
     * 回调地址
     */
    @ApiModelProperty(value = "回调地址")
    private String webServerRedirectUri;

    /**
     * 权限列表
     */
    @ApiModelProperty(value = "权限列表")
    private String authorities;

    /**
     * 请求令牌有效时间
     */
    @ApiModelProperty(value = "请求令牌有效时间")
    private Integer accessTokenValidity;

    /**
     * 刷新令牌有效时间
     */
    @ApiModelProperty(value = "刷新令牌有效时间")
    private Integer refreshTokenValidity;

    /**
     * 扩展信息
     */
    @ApiModelProperty(value = "扩展信息")
    private String additionalInformation;

    /**
     * 是否自动放行
     */
    @ApiModelProperty(value = "是否自动放行")
    private String autoapprove;

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
     * 租户ID
     */
    @ApiModelProperty(value = "租户ID")
    private Long tenantId;

}
