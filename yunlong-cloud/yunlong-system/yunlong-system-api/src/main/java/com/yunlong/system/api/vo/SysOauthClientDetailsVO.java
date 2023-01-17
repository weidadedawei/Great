package com.yunlong.system.api.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 终端信息表(SysOauthClientDetails)
 *
 * @author david
 * @date 2023-01-16 18:23:54
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(value = "终端信息表VO")
public class SysOauthClientDetailsVO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
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
    private String authorizedGrantTypes;

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
    @ApiModelProperty(value = "删除标识")
    private Boolean delFlag;

    /**
     * 租户ID
     */
    @ApiModelProperty(value = "租户ID")
    private Long tenantId;

}
