package com.yunlong.system.biz.service.impl;

import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yunlong.system.api.dto.UserInfo;
import com.yunlong.system.api.entity.SysUser;
import com.yunlong.system.api.entity.SysMenu;
import com.yunlong.system.api.entity.SysRole;
import com.yunlong.system.biz.mapper.SysUserMapper;
import com.yunlong.system.biz.mapper.SysUserPostMapper;
import com.yunlong.system.biz.service.*;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 用户表(SysUser)服务实现类
 *
 * @author david
 * @date 2023-01-02 20:03:01
 */
@Slf4j
@Service
@AllArgsConstructor
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    private final SysMenuService sysMenuService;

    private final SysRoleService sysRoleService;

    private final SysDeptService sysDeptService;

    private final SysUserRoleService sysUserRoleService;

    private final SysUserPostMapper sysUserPostMapper;

    /**
     * 通过查用户的全部信息
     *
     * @param sysUser 用户
     * @return
     */
    @Override
    public UserInfo findUserInfo(SysUser sysUser) {
        UserInfo userInfo = new UserInfo();
        userInfo.setSysUser(sysUser);
        // 设置角色列表 （ID）
        List<Long> roleIds = sysRoleService.findRolesByUserId(sysUser.getUserId()).stream().map(SysRole::getRoleId)
                .collect(Collectors.toList());
        userInfo.setRoles(ArrayUtil.toArray(roleIds, Long.class));

        // 设置权限列表（menu.permission）
        Set<String> permissions = new HashSet<>();
        roleIds.forEach(roleId -> {
            List<String> permissionList = sysMenuService.findMenuByRoleId(roleId).stream()
                    .filter(menu -> StrUtil.isNotEmpty(menu.getPermission())).map(SysMenu::getPermission)
                    .collect(Collectors.toList());
            permissions.addAll(permissionList);
        });
        userInfo.setPermissions(ArrayUtil.toArray(permissions, String.class));
        return userInfo;
    }
}
