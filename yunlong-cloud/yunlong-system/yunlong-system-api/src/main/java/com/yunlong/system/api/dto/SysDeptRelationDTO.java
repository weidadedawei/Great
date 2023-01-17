package com.yunlong.system.api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 部门关系表(SysDeptRelation)
 *
 * @author david
 * @date 2023-01-05 12:36:40
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(value = "部门关系表DTO")
public class SysDeptRelationDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 祖先节点
     */
    @ApiModelProperty(value = "祖先节点")
    private Long ancestor;

    /**
     * 后代节点
     */
    @ApiModelProperty(value = "后代节点")
    private Long descendant;

}
