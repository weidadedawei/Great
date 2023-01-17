package com.yunlong.system.biz.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yunlong.system.api.entity.SysMenu;

import java.util.List;

/**
 * 菜单权限表(SysMenu)服务接口
 *
 * @author david
 * @date 2023-01-05 12:39:39
 */
public interface SysMenuService extends IService<SysMenu> {

    /**
     * 通过角色编号查询URL 权限
     * @param roleId 角色ID
     * @return 菜单列表
     */
    List<SysMenu> findMenuByRoleId(Long roleId);
}
