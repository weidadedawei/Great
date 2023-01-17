package com.yunlong.system.api.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 用户角色表(SysUserRole)表实体类
 *
 * @author david
 * @date 2023-01-05 12:36:40
 */
@Data
@TableName("sys_user_role")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "审核日志表")
public class SysUserRole extends Model<SysUserRole> {

    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
    @TableId
    @ApiModelProperty(value = "用户ID")
    private Long userId;

    /**
     * 角色ID
     */
    @ApiModelProperty(value = "角色ID")
    private Long roleId;

}