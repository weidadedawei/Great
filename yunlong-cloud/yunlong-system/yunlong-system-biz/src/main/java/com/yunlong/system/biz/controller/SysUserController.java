package com.yunlong.system.biz.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yunlong.frame.core.util.R;
import com.yunlong.frame.log.annotation.SysLog;
import com.yunlong.frame.security.annotation.Inner;
import com.yunlong.system.api.entity.SysUser;
import com.yunlong.system.biz.service.SysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * 用户表(SysUser)控制层
 *
 * @author david
 * @date 2023-01-02 20:02:56
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/sysUser")
@Api(value = "sysUser", tags = "用户表")
public class SysUserController {

    private final SysUserService sysUserService;

    /**
     * 获取指定用户全部信息
     *
     * @return 用户信息
     */
    @Inner
    @GetMapping("/info/{username}")
    public R info(@PathVariable String username) {
        SysUser user = sysUserService.getOne(Wrappers.<SysUser>query().lambda().eq(SysUser::getUsername, username));
        if (user == null) {
            return R.failed("用户信息为空");
        }
        return R.success(sysUserService.findUserInfo(user));
    }

    /**
     * 分页查询
     *
     * @param page    分页对象
     * @param sysUser 用户表
     * @return
     */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page")
    @SysLog("查询用户表")
    public R getSysUserPage(Page page, SysUser sysUser) {
        return R.success(sysUserService.page(page, Wrappers.query(sysUser)));
    }

    /**
     * 通过id查询用户表
     *
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id查询", notes = "通过id查询")
    @GetMapping("/{id}")
    public R getById(@PathVariable("id") Long id) {
        return R.success(sysUserService.getById(id));
    }

    /**
     * 新增用户表
     *
     * @param sysUser 用户表
     * @return R
     */
    @ApiOperation(value = "新增用户表", notes = "新增用户表")
    @SysLog("新增用户表")
    @PostMapping
    public R save(@Valid @RequestBody SysUser sysUser) {
        return R.success(sysUserService.save(sysUser));
    }

    /**
     * 修改用户表
     *
     * @param sysUser 用户表
     * @return R
     */
    @ApiOperation(value = "修改用户表", notes = "修改用户表")
    @SysLog("修改用户表")
    @PutMapping
    public R updateById(@RequestBody SysUser sysUser) {
        return R.success(sysUserService.updateById(sysUser));
    }

    /**
     * 通过id删除用户表
     *
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id删除用户表", notes = "通过id删除用户表")
    @SysLog("通过id删除用户表")
    @DeleteMapping("/{id}")
    public R removeById(@PathVariable Long id) {
        return R.success(sysUserService.removeById(id));
    }

    /**
     * 导出excel 表格
     *
     * @param sysUser 查询条件
     * @return excel 文件流
     */
//    @ResponseExcel
    @GetMapping("/export")
    public List<SysUser> export(SysUser sysUser) {
        return sysUserService.list(Wrappers.query(sysUser));
    }

    @GetMapping("/getCurrentUser")
    public Object getCurrentUser(Authentication authentication) {
        return authentication.getPrincipal();
    }
}
