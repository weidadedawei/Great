package com.yunlong.system.api.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 菜单权限表(SysMenu)
 *
 * @author david
 * @date 2023-01-05 12:36:40
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(value = "菜单权限表VO")
public class SysMenuVO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 菜单ID
     */
    @ApiModelProperty(value = "菜单ID")
    private Long menuId;

    /**
     * 菜单名
     */
    @ApiModelProperty(value = "菜单名")
    private String name;

    /**
     * 权限标识
     */
    @ApiModelProperty(value = "权限标识")
    private String permission;

    /**
     * 路径
     */
    @ApiModelProperty(value = "路径")
    private String path;

    /**
     * 父菜单ID
     */
    @ApiModelProperty(value = "父菜单ID")
    private Long parentId;

    /**
     * 图标
     */
    @ApiModelProperty(value = "图标")
    private String icon;

    /**
     * 排序值
     */
    @ApiModelProperty(value = "排序值")
    private Integer sortOrder;

    /**
     * 保持活动
     */
    @ApiModelProperty(value = "保持活动")
    private String keepAlive;

    /**
     * 菜单类型0：左侧菜:1：按钮 2：顶部菜单
     */
    @ApiModelProperty(value = "菜单类型0：左侧菜:1：按钮 2：顶部菜单")
    private String menuType;

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
