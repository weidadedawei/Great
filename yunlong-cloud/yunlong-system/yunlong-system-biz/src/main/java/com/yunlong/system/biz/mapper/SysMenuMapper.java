package com.yunlong.system.biz.mapper;

import com.yunlong.frame.mybatis.base.BaseMapperX;
import com.yunlong.system.api.entity.SysMenu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 菜单权限表(SysMenu)表数据库访问层
 *
 * @author david
 * @date 2023-01-05 12:39:39
 */
@Mapper
public interface SysMenuMapper extends BaseMapperX<SysMenu> {

    /**
     * 通过角色编号查询菜单
     * @param roleId 角色ID
     * @return
     */
    List<SysMenu> listMenusByRoleId(Long roleId);
}
