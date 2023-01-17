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
 * 岗位信息表(SysPost)
 *
 * @author david
 * @date 2023-01-05 12:36:40
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(value = "岗位信息表VO")
public class SysPostVO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 岗位ID
     */
    @ApiModelProperty(value = "岗位ID")
    private Long postId;

    /**
     * 岗位编码
     */
    @ApiModelProperty(value = "岗位编码")
    private String postCode;

    /**
     * 岗位名称
     */
    @ApiModelProperty(value = "岗位名称")
    private String postName;

    /**
     * 岗位排序
     */
    @ApiModelProperty(value = "岗位排序")
    private Integer postSort;

    /**
     * 岗位描述
     */
    @ApiModelProperty(value = "岗位描述")
    private String remark;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    /**
     * 创建人
     */
    @ApiModelProperty(value = "创建人")
    private String creator;

    /**
     * 更新时间
     */
    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updateTime;

    /**
     * 更新人
     */
    @ApiModelProperty(value = "更新人")
    private String updater;

    /**
     * 是否删除  -1：已删除  0：正常
     */
    @ApiModelProperty(value = "是否删除  -1：已删除  0：正常")
    private Boolean delFlag;

    /**
     * 租户ID
     */
    @ApiModelProperty(value = "租户ID")
    private Long tenantId;

}
