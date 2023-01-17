package com.yunlong.system.biz.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yunlong.frame.core.constant.CacheConstants;
import com.yunlong.system.api.entity.SysMenu;
import com.yunlong.system.biz.mapper.SysMenuMapper;
import com.yunlong.system.biz.mapper.SysRoleMenuMapper;
import com.yunlong.system.biz.service.SysMenuService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 菜单权限表(SysMenu)服务实现类
 *
 * @author david
 * @date 2023-01-05 12:39:39
 */
@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements SysMenuService {

    @Override
    @Cacheable(value = CacheConstants.MENU_DETAILS, key = "#roleId", unless = "#result.isEmpty()")
    public List<SysMenu> findMenuByRoleId(Long roleId) {
        return baseMapper.listMenusByRoleId(roleId);
    }
}
