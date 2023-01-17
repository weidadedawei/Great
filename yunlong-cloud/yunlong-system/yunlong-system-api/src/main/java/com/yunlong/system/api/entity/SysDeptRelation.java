package com.yunlong.system.api.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 部门关系表(SysDeptRelation)表实体类
 *
 * @author david
 * @date 2023-01-05 12:36:40
 */
@Data
@TableName("sys_dept_relation")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "审核日志表")
public class SysDeptRelation extends Model<SysDeptRelation> {

    private static final long serialVersionUID = 1L;

    /**
     * 祖先节点
     */
    @TableId
    @ApiModelProperty(value = "祖先节点")
    private Long ancestor;

    /**
     * 后代节点
     */
    @ApiModelProperty(value = "后代节点")
    private Long descendant;

}
