package com.yunlong.system.api.feign;


import com.yunlong.frame.core.constant.SecurityConstants;
import com.yunlong.frame.core.constant.ServiceNameConstants;
import com.yunlong.frame.core.util.R;
import com.yunlong.system.api.dto.UserInfo;
import com.yunlong.system.api.entity.SysUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;

/**
 * @author david
 * @date 2023/1/17
 */
@FeignClient(contextId = "remoteUserService", value = ServiceNameConstants.SYSTEM_SERVICE)
public interface RemoteUserService {

    /**
     * 通过用户名查询用户、角色信息
     *
     * @param username 用户名
     * @param from     调用标志
     * @return R
     */
    @GetMapping("/sysUser/info/{username}")
    R<UserInfo> info(@PathVariable("username") String username, @RequestHeader(SecurityConstants.FROM) String from);

    /**
     * 查询上级部门的用户信息
     *
     * @param username 用户名
     * @return R
     */
    @GetMapping("/sysUser/ancestor/{username}")
    R<List<SysUser>> ancestorUsers(@PathVariable("username") String username);

    /**
     * 锁定用户
     *
     * @param username 用户名
     * @param from     调用标识
     * @return
     */
    @PutMapping("/sysUser/lock/{username}")
    R<Boolean> lockUser(@PathVariable("username") String username, @RequestHeader(SecurityConstants.FROM) String from);

}
