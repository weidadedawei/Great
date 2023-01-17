package com.yunlong.system.biz.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yunlong.system.api.entity.SysRole;
import com.yunlong.system.biz.mapper.SysRoleMapper;
import com.yunlong.system.biz.service.SysRoleMenuService;
import com.yunlong.system.biz.service.SysRoleService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 系统角色表(SysRole)服务实现类
 *
 * @author david
 * @date 2023-01-05 12:40:24
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {

    private SysRoleMenuService roleMenuService;

    /**
     * 通过用户ID，查询角色信息
     * @param userId
     * @return
     */
    @Override
    public List findRolesByUserId(Long userId) {
        return baseMapper.listRolesByUserId(userId);
    }
}
