package com.yunlong.system.biz.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yunlong.system.api.dto.UserInfo;
import com.yunlong.system.api.entity.SysUser;

/**
 * 用户表(SysUser)服务接口
 *
 * @author david
 * @date 2023-01-02 20:02:59
 */
public interface SysUserService extends IService<SysUser> {

    /**
     * 通过查用户的全部信息
     *
     * @param sysUser 用户
     * @return
     */
    UserInfo findUserInfo(SysUser sysUser);
}
