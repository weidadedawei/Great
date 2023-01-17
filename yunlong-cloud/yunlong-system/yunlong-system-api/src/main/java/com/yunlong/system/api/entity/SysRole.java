package com.yunlong.system.api.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * 系统角色表(SysRole)表实体类
 *
 * @author david
 * @date 2023-01-05 12:36:40
 */
@Data
@TableName("sys_role")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "审核日志表")
public class SysRole extends Model<SysRole> {

    private static final long serialVersionUID = 1L;


    @TableId
    @ApiModelProperty(value = "")
    private Long roleId;

    /**
     * 角色名称
     */
    @ApiModelProperty(value = "角色名称")
    private String roleName;

    /**
     * 角色编码
     */
    @ApiModelProperty(value = "角色编码")
    private String roleCode;

    /**
     * 角色描述
     */
    @ApiModelProperty(value = "角色描述")
    private String roleDesc;

    /**
     * 数据权限类型
     */
    @ApiModelProperty(value = "数据权限类型")
    private String dsType;

    /**
     * 数据权限作用范围
     */
    @ApiModelProperty(value = "数据权限作用范围")
    private String dsScope;

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
