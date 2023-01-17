package com.yunlong.system.biz.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yunlong.system.api.entity.SysRole;

import java.util.List;

/**
 * 系统角色表(SysRole)服务接口
 *
 * @author david
 * @date 2023-01-05 12:40:24
 */
public interface SysRoleService extends IService<SysRole> {

    /**
     * 通过用户ID，查询角色信息
     * @param userId
     * @return
     */
    List<SysRole> findRolesByUserId(Long userId);
}
