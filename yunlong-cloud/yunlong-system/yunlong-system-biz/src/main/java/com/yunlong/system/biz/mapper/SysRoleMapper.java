package com.yunlong.system.biz.mapper;

import com.yunlong.frame.mybatis.base.BaseMapperX;
import com.yunlong.system.api.entity.SysRole;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 系统角色表(SysRole)表数据库访问层
 *
 * @author david
 * @date 2023-01-05 12:40:24
 */
@Mapper
public interface SysRoleMapper extends BaseMapperX<SysRole> {

    /**
     * 通过用户ID，查询角色信息
     * @param userId
     * @return
     */
    List<SysRole> listRolesByUserId(Long userId);
}
